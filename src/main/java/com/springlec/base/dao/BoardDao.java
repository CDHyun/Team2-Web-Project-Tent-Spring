package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Board;

public interface BoardDao {

	// 게시판 리스트 조회 + 페이징, 검색
	public List<Board> boardList(String query, int startRow, int endRow) throws Exception;
	
	// 게시판 글 개수 카운트
	public int boardCount(String query) throws Exception;
	
	// 게시글 작성
	public int write_board(Board board) throws Exception;
	
	// 게시글 조회수 증가
	public int increaseViewCount(int bNo) throws Exception;
	
	// 게시글 상세 보기
	public Board board_detail(int bNo) throws Exception;
	
	// 게시글 삭제
	public int delete_board(int bNo) throws Exception;
	
	
}	// End Class
