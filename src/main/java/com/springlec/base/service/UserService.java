package com.springlec.base.service;

import com.springlec.base.model.User;

public interface UserService {

	// 회원 가입
	public int signUp(User user) throws Exception;
	
	// 아이디 중복 체크
	public int checkDuplicateId(String uid) throws Exception;
	
	// 로그인 체크
	public int loginCheck(String uid, String uPassword) throws Exception;
	
	
	
	
	
}	// End Class
