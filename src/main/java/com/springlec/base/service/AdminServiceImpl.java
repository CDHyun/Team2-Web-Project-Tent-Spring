package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminDao;
import com.springlec.base.model.Admin;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	
	@Override
	public List<Admin> selectlist() throws Exception {
		// TODO Auto-generated method stub
		
		//content = "%" + content + '%';
		return adminDao.selectlist();
	}

}
