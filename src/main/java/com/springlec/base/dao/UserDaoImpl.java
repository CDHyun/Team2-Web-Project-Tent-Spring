package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.User;

public class UserDaoImpl implements UserDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.UserDao";
	
	@Override
	public int signUp1(User user) throws Exception {
		return sqlSession.insert(nameSpace + ".signUp1");
	}

	@Override
	public int signUp2(User user) throws Exception {
		return sqlSession.insert(nameSpace + ".signUp2");
	}

	@Override
	public int checkDuplicateId(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".checkDuplicateId");
	}

	@Override
	public int statusCheck(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".statusCheck");
	}

	@Override
	public int existCheck(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".existCheck");
	}

	@Override
	public int accordCheck(String uid, String uPassword) throws Exception {
		return sqlSession.selectOne(nameSpace + ".accordCheck");
	}

	@Override
	public String getUserNickname(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getUserNickname");
	}
	
	

}
