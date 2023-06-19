package com.springlec.base.dao;

import java.util.List;

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
	
	// 아이디, 비밀번호 일치 여부 체크
	public int accordCheck(String uid, String uPassword) throws Exception;
	
	// 로그인 유저의 닉네임 가져오기
	public String getUserNickname(String uid) throws Exception;
	
	// 유저 회원 정보
	public User userInfo(String uid) throws Exception;
	
	// 유저 핸드폰 번호 변경
	public int modify_phone(String uid, String uPhone) throws Exception;
	
	// 유저 이름 변경
	public int modify_name(String uid, String uName) throws Exception;
	
	// 유저 이메일 변경
	public int modify_email(String uid, String uEmail) throws Exception;
	
	// 유저 이메일 변경
	public int modify_nickname(String uid, String uNickName) throws Exception;
	
	// 유저 회원 탈퇴
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
	
	// 관리자 로그인
	public int admin_login(String aid, String aPassword) throws Exception;
	
	// 이메일 중복 체크
	public int checkDuplicateEmail(String uEmail) throws Exception;
	
	// 이메일 탈퇴 여부 체크
	public int statusCheckEmail(String uEmail) throws Exception;
	
	// 이메일로 아이디 가져오기
	public String getUserId(String uEmail) throws Exception;
	
	
	
	
}	// End Class
