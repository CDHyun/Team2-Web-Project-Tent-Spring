package com.springlec.base.service;

import com.springlec.base.model.User;

public interface UserService {

	// 회원 가입
	public int signUp(User user) throws Exception;
	
	// 아이디 중복 체크
	public int checkDuplicateId(String uid) throws Exception;
	
	// 로그인 체크
	public int loginCheck(String uid, String uPassword) throws Exception;
	
	// 로그인 유저의 닉네임 가져오기
	public String getUserNickname(String uid) throws Exception;
	
	// 회원 정보
	public User userInfo(String uid) throws Exception;
	
	// 핸드폰 번호 변경
	public int modify_phone(String uid, String uPhone) throws Exception;
	
	//아이디 비밀번호 일치여부 확인
	public int accordCheck(String uid, String uPassword) throws Exception;
	
	
	
	
	
}	// End Class
