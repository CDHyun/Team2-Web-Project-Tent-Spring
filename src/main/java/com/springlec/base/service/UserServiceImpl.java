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
			return -1;	// 실패
		}
		return insertRowCount1;	// 성공
	}

	@Override
	public int checkDuplicateId(String uid) throws Exception {
		int rowCount = userDao.checkDuplicateId(uid);
		return rowCount;
	}

}	// End Class
