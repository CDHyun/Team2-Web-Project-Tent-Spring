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

	// 회원가입 중복 체크
	public int checkDuplicateId(String uid) throws Exception;
	
	// 로그인 탈퇴 여부 체크
	public int statusCheck(String uid) throws Exception;
	
	// 로그인 존재 여부 체크
	public int existCheck(String uid) throws Exception;
	
	// 로그인 일치 여부 체크
	public int accordCheck(String uid, String uPassword) throws Exception;
	
}	// End Class
