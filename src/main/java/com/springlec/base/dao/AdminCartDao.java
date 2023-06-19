package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Cart;

public interface AdminCartDao {

	
	
	//카트리스트불러오기
	public List<Cart> cartSelect(String uid) throws Exception; 
	
	//카트 상품추천
	public List<Cart> recommend() throws Exception; 
	
	
	// 카트합계금액
	public int countSum() throws Exception;
	
	// 카트항목삭제
	public void deleteCart(int cNo) throws Exception;
	
	// 상품디테일에서 카트에 상품담기
	public void addCart(String uid, int pCode, int pcQty, String pColor) throws Exception;
	
}
