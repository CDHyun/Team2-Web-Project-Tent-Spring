package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.QnADao;
import com.springlec.base.model.Answer;
import com.springlec.base.model.Question;

@Service
@Transactional
public class QnAServiceImpl implements QnAService {

	@Autowired
	QnADao qnADao;
	
	@Override
	public List<Question> question_list() throws Exception {
		return qnADao.question_list();
	}

	@Override
	public int increaseQuestionViewCount(int qNo) throws Exception {
		return qnADao.increaseQuestionViewCount(qNo);
	}

	@Override
	public int write_question(Question question) throws Exception {
		return qnADao.write_question(question);
	}

	@Override
	public Question question_detail(int qNo) throws Exception {
		return qnADao.question_detail(qNo);
	}

	@Override
	public Answer getAnswer(int qNo) throws Exception {
		return qnADao.getAnswer(qNo);
	}

	@Override
	public int answer_complete(int qNo) throws Exception {
		return qnADao.answer_complete(qNo);
	}

	@Override
	public int write_answer(Answer answer) throws Exception {
		int qNo = answer.getqNo();
		qnADao.answer_complete(qNo);
		return qnADao.write_answer(answer);
	}

}
