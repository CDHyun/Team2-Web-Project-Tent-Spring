package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.CartDto;

public interface CartService {

	// 카트 리스트 불러오기
	public List<CartDto> listDao() throws Exception;
	
	// 카트 데이터 입력
	public void insert(CartDto dto) throws Exception;
	
}// End
