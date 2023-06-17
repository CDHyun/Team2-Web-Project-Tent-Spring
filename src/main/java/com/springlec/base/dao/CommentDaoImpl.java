package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Comment;

public class CommentDaoImpl implements CommentDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.CommentDao";

	@Override
	public int commentCount(int bNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".commentCount");
	}

	@Override
	public List<Comment> commentList(int bNo, int startRow, int endRow) throws Exception {
		return sqlSession.selectList(nameSpace + ".commentList");
	}

	@Override
	public int write_parent_comment(Comment comment) throws Exception {
		return sqlSession.insert(nameSpace + ".write_parent_comment");
	}

	@Override
	public int getMaxCmRef(int bNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getMaxCmRef");
	}

	@Override
	public Comment getCommentByCmNo(int cmNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getCommentByCmNo");
	}

	@Override
	public int getAnswerCount(int bNo, int cmNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getAnswerCount");
	}

	@Override
	public int getMaxStep(int cmRef, int bNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getMaxStep");
	}

	@Override
	public int updateRefOrderGreaterThan(int cmRef, int cmRefOrder, int bNo) throws Exception {
		return sqlSession.update(nameSpace + ".updateRefOrderGreaterThan");
	}

	@Override
	public int saveComment(int bNo, String uid, String uNickName, int cmRef, int cmStep, int cmRefOrder, int cmParentNo, String cmContent) throws Exception {
		return sqlSession.insert(nameSpace + ".saveComment");
	}

	@Override
	public int increaseCount(int cmNo) throws Exception {
		return sqlSession.update(nameSpace + ".increaseCount");
	}

	@Override
	public int getRefOrder(int cmNo, int bNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getRefOrder");
	}

}
