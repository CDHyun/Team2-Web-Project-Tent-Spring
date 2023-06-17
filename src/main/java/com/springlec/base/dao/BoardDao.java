package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Board;

public interface BoardDao {

	// 게시판 리스트 조회 + 페이징, 검색
	public List<Board> boardList(String query, int startRow, int endRow) throws Exception;
	
	// 게시판 글 개수 카운트
	public int boardCount(String query) throws Exception;
	
	
}	// End Class
