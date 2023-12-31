package com.springlec.base.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Admin;

public interface AdminDao {
	
	
	//admin 상품관리
	public List<Admin> selectlist(int index_no) throws Exception;
	
	// 상품 갯수 count
	public int productCount() throws Exception;
	
	// 상품관리 검색
	public List<Admin> querySelect(String query, String content) throws Exception;
	
	//  날짜별 매출
	public List<Admin> dailySale(String startDate, String endDate) throws Exception;
	
	
	// sql 설정변경
	public void setSqlMode() throws Exception;
	// 막대차트
	public List<Admin> chart() throws Exception;
	
	//admin 상품수정삭제 공유
	public List<Admin> sharelist() throws Exception;

	// admin 상품수정,삭제 페이지
	public Admin contentviewDao(int pCode, String pColor) throws Exception;
	
	//상품수정
	public void updateProduct1(String pName,String pBrandName,int pPrice,int pCode) throws Exception;
	public void updateProduct2(String pColor,int pStock,int pCode) throws Exception;
	public void updateProduct3(String lastfile, int pCode) throws Exception;
	
	// 상품삭제
	public void deleteProduct(int pCode, String pColor) throws Exception;
	
	 
	
	// admin 상품등록
	public void insert1(String pName, String pBrandName, int pPrice, int cgNo) throws Exception;
	
	public void insert2(int pCode, int pStock, String pColor, String pName) throws Exception;

	
	// admin 상품사진등록
	public void upload(String pfName, String pfRealName, String pfHoverName,String pfHoverRealName,int pCode) throws Exception;
	
	// admin 상품사진등록
	public void upload1(String pfName, String pfRealName, int pCode) throws Exception;
	
	// 주문상태 
	public List<Admin> statusCheck() throws Exception;
	
	// 주문상태변경
	public void changeStatus (int pcNo, int pcStatus) throws Exception;
	
	
	// 고객관리 notice
	public List<Admin> customer() throws Exception;
	
	// 고객관리 faq
	public List<Admin> faq() throws Exception;
	
	// 공지등록
	public void noticeInsert(String nTitle, String nContent,String aid,int nCgNo) throws Exception;
	
	//도넛차트
	public List<Admin> donut() throws Exception;
	
	public List<Admin> except() throws Exception;
	
	//admin 리뷰관리 
	public List<Admin> review() throws Exception;
	
	// 고객관리 QNA
	public List<Admin> qna() throws Exception;
	
}
