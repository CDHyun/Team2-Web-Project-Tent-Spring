package com.springlec.base.dao;

import com.springlec.base.model.User;

/*
 06/16 : UserDao 추가 
 */
public interface UserDao {
	// 회원가입 (user Table)
	public int signUp1(User user) throws Exception;
	// 회원가입 (userAddress Table)
	public int signUp2(User user) throws Exception;

	// 중복 체크
	public int checkDuplicateId(String uid) throws Exception;
}
