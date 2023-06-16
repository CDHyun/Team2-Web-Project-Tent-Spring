package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.CartDto;

public class CartDaoImpl implements CartDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.CartDao";
	
	
	// 카트 리스트 불러주기
	@Override
	public List<CartDto> listDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + "listDao");
	}
	
	// 카트 데이터 입력
	@Override
	public void insertDao(CartDto dto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + "insertDao");
	}
	
	

}// End
