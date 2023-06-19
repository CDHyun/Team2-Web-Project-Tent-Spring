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
	public int countSum() throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.countSum();
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
}
