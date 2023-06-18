package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Cart;

public interface AdminCartService {

	
		//카트리스트불러오기
		public List<Cart> cartSelect() throws Exception; 
		
		// 카트합계금액
		public int countSum() throws Exception;
		
		// 카트항목삭제
		public void deleteCart(int cNo) throws Exception;
		
		//카트 상품추천
		public List<Cart> recommend() throws Exception; 
	
	
}
