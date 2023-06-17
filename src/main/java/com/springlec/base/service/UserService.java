package com.springlec.base.service;

import java.util.List;

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
	
	// 이름 변경
	public int modify_name(String uid, String uName) throws Exception;
	
	// 이메일 변경
	public int modify_email(String uid, String uEmail) throws Exception;
	
	// 닉네임 변경
	public int modify_nickname(String uid, String uNickName) throws Exception;
	
	// 회원 탈퇴
	public int delete_account(String uid) throws Exception;
	
	// 배송지 조회
	public List<User> my_address(String uid) throws Exception;
	
	// 가장 높은 uaNo 조회
	public int getUaNo(String uid) throws Exception;
	
	// 배송지 추가
	public int add_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent);
	
	// 배송지 수정
	public int modify_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent);
	
	// 배송지 삭제
	public int delete_address(String uid, int uaNo) throws Exception;
	
	// 비밀번호 변경
	public int change_password(String uid, String uPassword) throws Exception;
	
	
	
	
}	// End Class
