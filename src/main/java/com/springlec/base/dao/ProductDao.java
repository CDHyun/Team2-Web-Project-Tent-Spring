package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductDao {

	// 상품 리스트 불러오기
	public List<Product> productList(String query) throws Exception;
	
}	// End Class
