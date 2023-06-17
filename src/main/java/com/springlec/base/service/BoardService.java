package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Board;

public interface BoardService {
	
	// 게시판 리스트 조회 + 검색, 페이징
	public List<Board> boardList(String query, int pageNo) throws Exception; 
	
	// 게시판 글 카운트
	public int boardCount(String query) throws Exception;

	// 게시글 작성
	public int write_board(Board board) throws Exception;
	
	
}	// End Class
