package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminCartDao;
import com.springlec.base.model.Cart;

@Service
public class AdminCartServiceImpl implements AdminCartService {

	
	@Autowired
	AdminCartDao adminCartDao;

	@Override
	public List<Cart> cartSelect(String uid) throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.cartSelect(uid);
	}

	@Override
	public int countSum(String uid) throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.countSum(uid);
	}

	@Override
	public void deleteCart(int cNo) throws Exception {
		// TODO Auto-generated method stub
		adminCartDao.deleteCart(cNo);
	}

	@Override
	public List<Cart> recommend() throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.recommend();
	}

	@Override
	public void addCart(String uid, int pCode, int pcQty, String pColor) throws Exception {
		// TODO Auto-generated method stub
		adminCartDao.addCart(uid, pCode, pcQty, pColor);
	}

	@Override
	public List<Cart> wishlistSelect(String uid) throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.wishlistSelect(uid);
	}

	@Override
	public void insertWish(String uid, int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		adminCartDao.insertWish(uid, pCode, pColor);
	}

	@Override
	public void wishCart(String wNo) throws Exception {
		// TODO Auto-generated method stub
		adminCartDao.wishCart(wNo);
	}

	@Override
	public void deleteWish(String wNo) throws Exception {
		// TODO Auto-generated method stub
		adminCartDao.deleteWish(wNo);
	}

	@Override
	public int increaseQty(int cNo) throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.increaseQty(cNo);
	}
	@Override
	public int decreaseQty(int cNo) throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.decreaseQty(cNo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
