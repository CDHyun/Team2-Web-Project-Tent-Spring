package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Product;

public class ProductDaoImpl implements ProductDao {

	SqlSession sqlSession;

	public static String nameSpace = "com.springlec.base.dao.ProductDao";
	
	@Override
	public List<Product> productList(String query) throws Exception {
		if(query == null) {
			query = "";
		}
		return sqlSession.selectList(nameSpace + ".productList");
	}
	
	
	
	
}	// End Class
