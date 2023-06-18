package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.UserDao;
import com.springlec.base.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	// 회원 가입
	@Override
	public int signUp(User user) throws Exception {
		int insertRowCount1 = userDao.signUp1(user);
		int insertRowCount2 = userDao.signUp2(user);
		if(insertRowCount1 > 0 && insertRowCount2 > 0) {
			return 1;	// 성공
		}
		return -1;	// 실패
	}

	@Override
	public int checkDuplicateId(String uid) throws Exception {
		int rowCount = userDao.checkDuplicateId(uid);
		return rowCount;
	}

	@Override
	public int loginCheck(String uid, String uPassword) throws Exception {
	    /*
	     -2 : 존재하지 않음
	     -1 : 탈퇴함
	     0  : 아이디, 비밀번호 일치하지 않음
	     1  : 로그인 성공
	     */
	    int result = 0;
	    
	    // 존재 여부 확인
	    int exist = userDao.existCheck(uid);
	    
	    if(exist == 0) {
	    	result = -2;	// 존재하지 않음
	    	return result;
	    } else {
	    	int status = userDao.statusCheck(uid);
	    	if(status == 1) {
	    		result = -1;	// 탈퇴함.
	    		return result;
	    	} else {
	    		int accord = userDao.accordCheck(uid, uPassword);
	    		if(accord == 0) {
	    			result = 0;		// 틀림
	    			return result;
	    		} else {
	    			result = accord;
	    		}
	    	}
	    }
	    return result;
	}
	
	// 로그인 유저의 닉네임 가져오기
	@Override
	public String getUserNickname(String uid) throws Exception {
		return userDao.getUserNickname(uid);
	}

	// 회원 정보
	@Override
	public User userInfo(String uid) throws Exception {
		return userDao.userInfo(uid);
	}

	@Override
	public int modify_phone(String uid, String uPhone) throws Exception {
		int result = userDao.modify_phone(uid, uPhone);
		return result;
	}

	@Override
	public int accordCheck(String uid, String uPassword) throws Exception {
		return userDao.accordCheck(uid, uPassword);
	}

	@Override
	public int modify_name(String uid, String uName) throws Exception {
		return userDao.modify_name(uid, uName);
	}

	@Override
	public int modify_email(String uid, String uEmail) throws Exception {
		return userDao.modify_email(uid, uEmail);
	}

	@Override
	public int modify_nickname(String uid, String uNickName) throws Exception {
		return userDao.modify_nickname(uid, uNickName);
	}

	@Override
	public int delete_account(String uid) throws Exception {
		return userDao.delete_account(uid);
	}

	@Override
	public List<User> my_address(String uid) throws Exception {
		return userDao.my_address(uid);
	}

	@Override
	public int add_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent) {
		return userDao.add_address(uid, uaNo, uaAddress, uaDetailAddress, uaZipcode, uaContent);
	}

	@Override
	public int getUaNo(String uid) throws Exception {
		return userDao.getUaNo(uid);
	}

	@Override
	public int modify_address(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent) {
		return userDao.modify_address(uid, uaNo, uaAddress, uaDetailAddress, uaZipcode, uaContent);
	}

	@Override
	public int delete_address(String uid, int uaNo) throws Exception {
		return userDao.delete_address(uid, uaNo);
	}

	@Override
	public int change_password(String uid, String uPassword) throws Exception {
		return userDao.change_password(uid, uPassword);
	}

	@Override
	public int admin_login(String aid, String aPassword) throws Exception {
		return userDao.admin_login(aid, aPassword);
	}



}	// End Class
