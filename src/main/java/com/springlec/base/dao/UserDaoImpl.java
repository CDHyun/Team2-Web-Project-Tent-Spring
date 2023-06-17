package com.springlec.base.dao;

import java.util.List;

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

	@Override
	public int modify_nickname(String uid, String uNickName) throws Exception {
		return sqlSession.update(nameSpace + ".modify_nickname");
	}

	@Override
	public int delete_account(String uid) throws Exception {
		return sqlSession.update(nameSpace + ".delete_account");
	}

	@Override
	public List<User> my_address(String uid) throws Exception {
		return sqlSession.selectList(nameSpace + ".my_address");
	}

	@Override
	public int getUaNo(String uid) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getUaNo");
	}

	@Override
	public int add_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent) {
		return sqlSession.insert(nameSpace + ".add_address");
	}

	@Override
	public int modify_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent) {
		return sqlSession.update(nameSpace + ".modify_address");
	}

	@Override
	public int delete_address(String uid, int uaNo) throws Exception {
		return sqlSession.delete(nameSpace + ".delete_address");
	}

	@Override
	public int change_password(String uid, String uPassword) throws Exception {
		return sqlSession.update(nameSpace + ".password_change");
	}
	
	

}
