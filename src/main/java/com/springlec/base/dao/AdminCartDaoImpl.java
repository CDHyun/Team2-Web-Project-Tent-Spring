package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.model.Cart;

public class AdminCartDaoImpl implements AdminCartDao {

	
	
	@Autowired
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.AdminCartDao";
	
	
	
	
	
	
	@Override
	public List<Cart> cartSelect(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".cartSelect");
	}






	@Override
	public int countSum(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".countSum");
	}






	@Override
	public void deleteCart(int cNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + ".deleteCart"); 
	}






	@Override
	public List<Cart> recommend() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".recommend");
	}






	@Override
	public void addCart(String uid, int pCode, int pcQty, String pColor) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".addCart"); 
	}






	@Override
	public List<Cart> wishlistSelect(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".wishlistSelect");
	}






	@Override
	public void insertWish(String uid, int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insertWish");
	}






	@Override
	public void wishCart(String wNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".wishCart");
	}






	@Override
	public void deleteWish(String wNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + ".deleteWish");
	}






	@Override
	public int increaseQty(int cNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".increaseQty");
	}
	@Override
	public int decreaseQty(int cNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".decreaseQty");
	}
	
	
	
	
	
	
	
	
	
	
}
