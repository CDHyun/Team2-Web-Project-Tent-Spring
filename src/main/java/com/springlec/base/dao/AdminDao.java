package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Admin;

public interface AdminDao {
	
	
	//admin 상품관리
	public List<Admin> selectlist() throws Exception;
	
	// 상품관리 검색
	public List<Admin> querySelect(String query, String content) throws Exception;
	
	//  날짜별 매출
	public List<Admin> dailySale(String startDate, String endDate) throws Exception;
	
	// 막대차트
	public List<Admin> chart() throws Exception;
	
	
	
	
	
	
	
}
