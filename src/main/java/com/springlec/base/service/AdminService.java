package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Admin;

public interface AdminService {
	
	//admin 상품관리
		public List<Admin> selectlist() throws Exception;

}
