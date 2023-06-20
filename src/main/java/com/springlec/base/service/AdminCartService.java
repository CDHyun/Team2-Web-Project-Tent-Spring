package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Cart;

public interface AdminCartService {

	
		//카트리스트불러오기
		public List<Cart> cartSelect(String uid) throws Exception; 
		
		// 카트합계금액
		public int countSum(String uid) throws Exception;
		
		// 카트항목삭제
		public void deleteCart(int cNo) throws Exception;
		
		//카트 상품추천
		public List<Cart> recommend() throws Exception; 
	
		// 상품디테일에서 카트에 상품담기
		public void addCart(String uid, int pCode, int pcQty, String pColor) throws Exception;

		// 위시리스트 보여주기
		public List<Cart> wishlistSelect(String uid) throws Exception; 
		
		// 위시리스트에 담기
		public void insertWish(String uid , int pCode, String pColor) throws Exception;
		
		// 위시리스트에서 카트로 이동
		public void wishCart(String wNo) throws Exception;

		// 위시리스트 항목삭제
		public void deleteWish(String wNo) throws Exception;

		// 카트수량 ajax
		public int increaseQty(int cNo) throws Exception;
		public int decreaseQty(int cNo) throws Exception;
		
		
		
		
		
		
		
		
		
		
		
		
	
}
