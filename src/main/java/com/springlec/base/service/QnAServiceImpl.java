package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.QnADao;
import com.springlec.base.model.Question;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	QnADao qnADao;
	
	@Override
	public List<Question> question_list() throws Exception {
		return qnADao.question_list();
	}

	@Override
	public int increaseQuestionViewCount(int qNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int write_question(Question question) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}