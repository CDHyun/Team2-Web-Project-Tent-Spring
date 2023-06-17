package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Admin;

import jakarta.servlet.http.HttpServletRequest;

public interface AdminService {
	
		//admin 상품관리
		public List<Admin> selectlist() throws Exception;
		
		// 상품관리 검색
		public List<Admin> querySelect(String query, String content) throws Exception;
		
		//  날짜별 매출
		public List<Admin> dailySale(String startDate, String endDate) throws Exception;
		
		// 막대차트
		public List<Admin> chart() throws Exception;
		
		//admin 상품수정삭제 공유페이지
		public List<Admin> sharelist() throws Exception;
		
		// admin 상품수정,삭제 페이지
		public Admin contentviewDao(int pCode, String pColor) throws Exception;
		
		// 상품삭제
		public void deleteProduct(int pCode, String pColor) throws Exception;
		
		// admin 상품등록 transaction
		public void insert( String pName, String pBrandName,String pPrice,String cgNo,String pCode
				,String pStock,String pColor,String pfNo,String pfName,String pfRealName,String pfHoverName,String pfHoverRealName) throws Exception;
		
		// 주문상태 
		public List<Admin> statusCheck() throws Exception;
		
		// 주문상태변경
		public void changeStatus (int pcNo, int pcStatus) throws Exception;
		
		// 고객관리 notice
		public List<Admin> customer() throws Exception;
		
		// 고객관리 faq
		public List<Admin> faq() throws Exception;
		
}
