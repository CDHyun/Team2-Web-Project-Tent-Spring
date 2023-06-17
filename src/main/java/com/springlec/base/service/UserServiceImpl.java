package com.springlec.base.service;

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


}	// End Class
