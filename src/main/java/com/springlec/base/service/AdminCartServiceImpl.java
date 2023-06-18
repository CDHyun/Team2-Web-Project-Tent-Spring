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
	public List<Cart> cartSelect() throws Exception {
		// TODO Auto-generated method stub
		return adminCartDao.cartSelect();
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
}
