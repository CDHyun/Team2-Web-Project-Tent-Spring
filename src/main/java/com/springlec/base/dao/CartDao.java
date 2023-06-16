package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.CartDto;

public interface CartDao {
	
	// 카트 리스트 불러오기
	public List<CartDto> listDao() throws Exception;
	
	// 카트에 데이터 입력
	public void insertDao(CartDto dto) throws Exception;
}// End
