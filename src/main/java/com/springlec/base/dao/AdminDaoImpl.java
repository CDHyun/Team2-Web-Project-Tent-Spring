package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Admin;

public class AdminDaoImpl implements AdminDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.AdminDao";
	
	@Override
	public List<Admin> selectlist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".selectlist");
	}

}
