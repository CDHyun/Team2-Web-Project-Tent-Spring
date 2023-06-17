package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.ProductDao;
import com.springlec.base.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	// 상품 리스트 불러오기
	@Override
	public List<Product> productList(String query) throws Exception {
		return productDao.productList(query);
	}
	
	
	
}	// End Class
