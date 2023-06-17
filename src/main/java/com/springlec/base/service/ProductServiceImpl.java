package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.ProductDao;
import com.springlec.base.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	// 상품 리스트 불러오기
	@Override
	public List<Product> productList(String query) throws Exception {
		return productDao.productList(query);
	}

	// 상품 정보 불러오기
	@Override
	public Product product_detail(int pCode) throws Exception {
		return productDao.product_detail(pCode);
	}

	@Override
	public List<Product> colorList(int pCode) throws Exception {
		return productDao.colorList(pCode);
	}
	
	
	
}	// End Class
