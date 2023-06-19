package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Admin;

public class AdminDaoImpl implements AdminDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.AdminDao";
	
	@Override
	public List<Admin> selectlist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".selectlist");
	}

	@Override
	public List<Admin> querySelect(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".querySelect");
	}

	@Override
	public List<Admin> dailySale(String startDate, String endDate) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".dailySale");
	}

	@Override
	public List<Admin> chart() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".chart");
	}

	@Override
	public List<Admin> sharelist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".sharelist");
	}

	@Override
	public Admin contentviewDao(int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		return (Admin) sqlSession.selectList(nameSpace + ".contentviewDao");
	
	}
 
	@Override
	public void insert1(String pName, String pBrandName, int pPrice, int cgNo) throws Exception {
		// TODO Auto-generated method stub
		 sqlSession.insert(nameSpace + ".insert1");
	}

	@Override
	public void insert2(int pCode, int pStock,String pColor, String pName) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insert2");
	}

	@Override
	public void upload(String pfName, String pfRealName, String pfHoverName,String pfHoverRealName,int pCode)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".upload");
	}

	@Override
	public List<Admin> statusCheck() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".statusCheck");	
	}

	@Override
	public List<Admin> customer() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customer");	
	}

	@Override
	public List<Admin> faq() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".faq");	
	}

	@Override
	public void changeStatus(int pcNo, int pcStatus) throws Exception {
		// TODO Auto-generated method stub
		 sqlSession.update(nameSpace + ".changeStatus");
	}

	@Override
	public void deleteProduct(int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".deleteProduct");
	}

	
	@Override
	public void updateProduct1(String pName, String pBrandName, int pPrice, int pCode
			) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateProduct1");
	}

	@Override
	public void updateProduct2( String pColor, int pStock, int pCode) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateProduct2");
	}
	@Override
	public void updateProduct3(String lastfile, int pCode) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateProduct3");
	}
	
	
	@Override
	public void setSqlMode() throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectOne(nameSpace + ".setSqlMode");
	}

	@Override
	public void upload1(String pfName, String pfRealName, int pCode) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".upload1");
	}

	

	@Override
	public void noticeInsert(String nTitle, String nContent,String aid,int nCgNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".noticeInsert");
	}


	

	
	

}
