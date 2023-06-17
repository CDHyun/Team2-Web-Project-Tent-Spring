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

}
