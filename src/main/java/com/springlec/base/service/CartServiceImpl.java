package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.CartDao;
import com.springlec.base.model.CartDto;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao dao;
	
	// 카트 리스트 불러오기
	@Override
	public List<CartDto> listDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.listDao();
	}

	// 카트 데이터 입력
	@Override
	public void insert(CartDto dto) throws Exception {
		// TODO Auto-generated method stub
		dao.insertDao(dto);
	}

}// End
