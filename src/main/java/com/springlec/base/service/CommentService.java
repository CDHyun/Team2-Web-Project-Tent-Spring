package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Comment;

public interface CommentService {

	// 댓글 개수 카운트
	public int commentCount(int bNo) throws Exception;
	
	// 댓글 리스트 조회 + 페이징, 검색
	public List<Comment> commentList(int bNo, int pageNo) throws Exception;
	
	
}	// End Class
