package com.springlec.base.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.springlec.base.dao.AdminDao;
import com.springlec.base.model.Admin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

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
		adminDao.setSQL();
		return adminDao.chart();
	}


	@Override
	public List<Admin> sharelist() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.sharelist();
	}


	@Override
	public Admin contentviewDao(int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		return  adminDao.contentviewDao(pCode, pColor);
	}

 
	@Override
	public void insert(String pName, String pBrandName, int pPrice, int cgNo, int pCode, int pStock,
			String pColor, int pfNo) throws Exception {
		// TODO Auto-generated method stub
		
	  
	    adminDao.insert1(pName, pBrandName, pPrice, cgNo);
	    adminDao.insert2(pCode, pStock, pColor,pName );
	   
	}
		
	

	@Override
	public void uploadFile(String pfName, String pfRealName, String pfHoverName, String pfHoverRealName, int pCode)
			throws Exception {
		// TODO Auto-generated method stub
		 adminDao.upload(pfName, pfRealName,pfHoverName, pfHoverRealName, pCode);
	}

	@Override
	public List<Admin> statusCheck() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.statusCheck();
	}


	@Override
	public List<Admin> customer() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.customer();
	}


	@Override
	public List<Admin> faq() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.faq();
	}


	@Override
	public void changeStatus(int pcNo, int pcStatus) throws Exception {
		// TODO Auto-generated method stub
		adminDao.changeStatus(pcNo, pcStatus);
		
	}


	@Override
	public void deleteProduct(int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		adminDao.deleteProduct(pCode, pColor);
	}


	@Override
	public void updateProduct(String pName, String pBrandName, int pPrice, int pCode, String pColor,
			int pStock) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateProduct1(pName, pBrandName, pPrice, pCode);
		adminDao.updateProduct2( pColor, pStock, pCode);
		
	}


	@Override
	public void uploadFile1(String pfName, String pfRealName, int pCode) throws Exception {
		// TODO Auto-generated method stub
		adminDao.upload1(pfName, pfRealName, pCode);
	}


	@Override
	public void updateProduct1(String pName, String pBrandName, int pPrice, int pCode, String pColor, int pStock,
			String lastfile) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateProduct1(pName, pBrandName, pPrice, pCode);
		adminDao.updateProduct2( pColor, pStock, pCode);
		adminDao.updateProduct3(lastfile, pCode);
	}


	



}
