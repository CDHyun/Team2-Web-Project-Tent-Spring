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
		// TODO Auto-generated method stub
		return 0;
	}

}	// End Class
