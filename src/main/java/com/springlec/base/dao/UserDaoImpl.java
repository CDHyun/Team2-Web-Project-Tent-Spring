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

	@Override
	public User userInfo(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userInfo");
	}

	@Override
	public int modify_phone(String uid, String uPhone) throws Exception {
		return sqlSession.update(nameSpace + ".modify_phone");
	}

	@Override
	public int modify_name(String uid, String uName) throws Exception {
		return sqlSession.update(nameSpace + ".modify_name");
	}

	@Override
	public int modify_email(String uid, String uEmail) throws Exception {
		return sqlSession.update(nameSpace + ".modify_email");
	}
	
	

}
