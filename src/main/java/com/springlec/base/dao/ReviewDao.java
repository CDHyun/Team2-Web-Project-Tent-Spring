package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Review;

public interface ReviewDao {

	// 리뷰 리스트 불러오기
	public List<Review> review_list(int pCode) throws Exception;
	
	
}	// End Class
