package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Comment;

public interface CommentService {

	// 댓글 개수 카운트
	public int commentCount(int bNo) throws Exception;
	
	// 댓글 리스트 조회 + 페이징, 검색
	public List<Comment> commentList(int bNo, int pageNo) throws Exception;
	
	// 부모 댓글 작성
	public int write_parent_comment(Comment comment) throws Exception;
	
	// MaxCmRef 찾기
	public int getMaxCmRef(int bNo) throws Exception;
	
	// 자식 댓글 작성 전에 부모 댓글 정보 불러오기
	public Comment getCommentByCmNo(int cmNo) throws Exception;
	
	// 부모 댓글의 AnswerCount 가져오기
	public int getAnswerCount(int bNo, int cmNo) throws Exception;
	
	// cmRef내의 MaxStep 가져오기
	public int getMaxStep(int cmRef, int bNo) throws Exception;
	
	// 그룹 내 댓글들의 cmRefOrder 증가 시키기
	public int updateRefOrderGreaterThan(int cmRef, int cmRefOrder, int bNo) throws Exception;
	
	// 댓글 저장하기
	public int saveComment(int bNo, String uid, String uNickName, int cmRef, int cmStep, int cmRefOrder, int cmParentNo, String cmContent) throws Exception;
	
	// 부모 댓글의 AnswerCount 증가 시키기
	public int increaseCount(int cmNo) throws Exception;

	// 부모 댓글의 cmRefOrder 가져오기
	public int getRefOrder(int cmNo, int bNo) throws Exception;
	
	// 댓글 저장 전 정렬을 수행해주는 메소드
	public void saveReply(int bNo, String uid, String uNickName, String cmContent, int cmParentNo) throws Exception;
	
	// 댓글 삭제하기
	public int delete_comment(int cmNo, int bNo) throws Exception;
	
	// 댓글 수정하기
	public int modify_comment(int cmNo, int bNo, String cmContent) throws Exception;
	
}	// End Class
