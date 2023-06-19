package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Review;

public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.ReviewDao";
	
	@Override
	public List<Review> review_list(int pCode) throws Exception {
		return sqlSession.selectList(nameSpace + ".review_list");
	}

}
