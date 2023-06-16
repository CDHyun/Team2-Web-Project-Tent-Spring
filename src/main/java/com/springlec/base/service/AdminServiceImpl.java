package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.AdminDao;
import com.springlec.base.model.Admin;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	
	@Override
	public List<Admin> selectlist() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectlist();
	}


	@Override
	public List<Admin> querySelect(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		content = "%" + content + '%';
		return adminDao.querySelect(query, content);
	}


	@Override
	public List<Admin> dailySale(String startDate, String endDate) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.dailySale(startDate,endDate);
	}


	@Override
	public List<Admin> chart() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.chart();
	}

}
