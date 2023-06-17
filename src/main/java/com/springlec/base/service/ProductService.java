package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductService {

	// 상품 리스트 불러오기
	public List<Product> productList(String query) throws Exception;
	
	// 상품 정보 불러오기
	public Product product_detail(int pCode) throws Exception;
	
	// 상품 컬러 리스트 불러오기
	public List<Product> colorList(int pCode) throws Exception;
	
}
