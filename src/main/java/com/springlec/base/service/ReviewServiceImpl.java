package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.ReviewDao;
import com.springlec.base.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public List<Review> review_list(int pCode) throws Exception {
		return reviewDao.review_list(pCode);
	}

}
