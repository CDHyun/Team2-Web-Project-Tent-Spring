package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Board;

public class BoardDaoImpl implements BoardDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.BoardDao";
	
	@Override
	public List<Board> boardList(String query, int startRow, int endRow) throws Exception {
		return sqlSession.selectList(nameSpace + ".boardList");
	}

	@Override
	public int boardCount(String query) throws Exception {
		return sqlSession.selectOne(nameSpace + ".boardCount");
	}

	@Override
	public int write_board(Board board) throws Exception {
		return sqlSession.insert(nameSpace + ".write_board");
	}

	@Override
	public int increaseViewCount(int bNo) throws Exception {
		return sqlSession.update(nameSpace + ".increaseViewCount");
	}

	@Override
	public Board board_detail(int bNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".board_detail");
	}

	@Override
	public int delete_board(int bNo) throws Exception {
		return sqlSession.update(nameSpace + ".delete_board");
	}

}	// End Class
