package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Admin;

public interface AdminDao {
	
	
	//admin 상품관리
	public List<Admin> selectList() throws Exception;
	

}
