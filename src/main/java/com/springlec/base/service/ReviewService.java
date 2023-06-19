package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Review;

public interface ReviewService {

	// 리뷰 리스트 불러오기
	public List<Review> review_list(int pCode) throws Exception;
	
}	// End Class
