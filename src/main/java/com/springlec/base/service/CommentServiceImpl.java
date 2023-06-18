package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.CommentDao;
import com.springlec.base.model.Comment;
import com.springlec.base.util.CommentPageMaker;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public int commentCount(int bNo) throws Exception {
		return commentDao.commentCount(bNo);
	}

	@Override
	public List<Comment> commentList(int bNo, int pageNo) throws Exception {
		CommentPageMaker commentPageMaker = new CommentPageMaker();
		int startRow = (pageNo - 1) * commentPageMaker.getDisplayRow() + 1;
		int endRow = pageNo * commentPageMaker.getDisplayRow();

		return commentDao.commentList(bNo, startRow, endRow);
	}

	@Override
	public int write_parent_comment(Comment comment) throws Exception {
		return commentDao.write_parent_comment(comment);
	}

	@Override
	public int getMaxCmRef(int bNo) throws Exception {
		return commentDao.getMaxCmRef(bNo);
	}

	@Override
	public Comment getCommentByCmNo(int cmNo) throws Exception {
		return commentDao.getCommentByCmNo(cmNo);
	}

	@Override
	public int getAnswerCount(int bNo, int cmNo) throws Exception {
		return commentDao.getAnswerCount(bNo, cmNo);
	}

	@Override
	public int getMaxStep(int cmRef, int bNo) throws Exception {
		return commentDao.getMaxStep(cmRef, bNo);
	}

	@Override
	public int updateRefOrderGreaterThan(int cmRef, int cmRefOrder, int bNo) throws Exception {
		return commentDao.updateRefOrderGreaterThan(cmRef, cmRefOrder, bNo);
	}

	@Override
	public int saveComment(int bNo, String uid, String uNickName, int cmRef, int cmStep, int cmRefOrder, int cmParentNo, String cmContent) throws Exception {
		commentDao.increaseCount(cmParentNo);
		return commentDao.saveComment(bNo, uid, uNickName, cmRef, cmStep, cmRefOrder, cmParentNo, cmContent);
	}

	@Override
	public int increaseCount(int cmNo) throws Exception {
		return commentDao.increaseCount(cmNo);
	}

	@Override
	public int getRefOrder(int cmNo, int bNo) throws Exception {
		return commentDao.getRefOrder(cmNo, bNo);
	}

	@Override
	public void saveReply(int bNo, String uid, String uNickName, String cmContent, int cmParentNo) throws Exception {
		Comment parentComment = getCommentByCmNo(cmParentNo);
		// 대댓글 저장 로직 구현
		int cmStep = 0; // 댓글은 step 0

		// ref의 최댓값 찾아서 ref에 +1 저장
		int maxRef = getMaxCmRef(bNo);

		// 대댓글의 부모댓글 찾기
		int cmRef = parentComment.getCmRef(); // 수정: 부모댓글의 cmRef 값을 할당받습니다.

		if (parentComment != null) {
			cmRef = parentComment.getCmRef();

			// 부모댓글의 step에 +1
			cmStep = parentComment.getCmStep() + 1;

			// 부모댓글의 자식 숫자 구하기
			int answerCount = getAnswerCount(bNo, cmParentNo);

			// 부모댓글의 그룹내 step 컬럼 최댓값 구하기
			int maxStep = getMaxStep(cmRef, bNo);

			// 대댓글의 step이 댓글의 그룹내에서 최대 step보다 작은 경우
			// 대댓글인 경우
			if (cmStep < maxStep) {
				// refOrder는 answerNumSum + 1
				int cmRefOrder = answerCount + 1;
				// 대댓글 저장
				saveComment(bNo, uid, uNickName, cmRef, cmStep, cmRefOrder, cmParentNo, cmContent);
				// 부모댓글의 그룹내 순서보다 큰 refOrder는 모두 +1 업데이트
				updateRefOrderGreaterThan(cmRef, cmRefOrder, bNo);
			}
			// 대대댓글이 존재하는 상태에서 대대댓글인 경우
			// 대댓글의 step이 댓글의 그룹내에서 최대 step과 같은 경우
			else if (cmStep == maxStep) {
				answerCount = getAnswerCount(bNo, cmParentNo);
				// cmRefOrder
				int cmRefOrder = getRefOrder(cmParentNo, bNo) + answerCount + 1;
				System.out.println("cmRefOrder = " + cmRefOrder);
				System.out.println("answerCount = " + answerCount);
				// 부모댓글의 그룹내 순서와 자식댓글을 더한 값보다 큰 refOrder는 모두 +1 업데이트
				updateRefOrderGreaterThan(cmRef, cmRefOrder, bNo);
				// 대댓글 저장
				saveComment(bNo, uid, uNickName, cmRef, cmStep, cmRefOrder, cmParentNo, cmContent);
			}
			// 새로운 대대댓글인 경우
			// 대댓글의 step이 댓글의 그룹내에서 최대 step보다 큰 경우
			else {
				// refOrder는 refOrder + 1
				int refOrder = getRefOrder(cmParentNo, bNo) + 1;
				// 부모댓글의 그룹내 순서보다 큰 refOrder는 모두 +1 업데이트
				updateRefOrderGreaterThan(cmRef, refOrder, bNo);
				// 대댓글 저장
				saveComment(bNo, uid, uNickName, cmRef, cmStep, refOrder, cmParentNo, cmContent);
			}

		}

	}

	@Override
	public int delete_comment(int cmNo, int bNo) throws Exception {
		return commentDao.delete_comment(cmNo, bNo);
	}

	@Override
	public int modify_comment(int cmNo, int bNo, String cmContent) throws Exception {
		return commentDao.modify_comment(cmNo, bNo, cmContent);
	}
}