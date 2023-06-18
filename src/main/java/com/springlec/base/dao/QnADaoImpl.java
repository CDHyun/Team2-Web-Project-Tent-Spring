package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Answer;
import com.springlec.base.model.Question;

public class QnADaoImpl implements QnADao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.QnADao";

	@Override
	public List<Question> question_list() throws Exception {
		return sqlSession.selectList(nameSpace + ".question_list");
	}

	@Override
	public int increaseQuestionViewCount(int qNo) throws Exception {
		return sqlSession.update(nameSpace + ".increaseQuestionViewCount");
	}

	@Override
	public int write_question(Question question) throws Exception {
		return sqlSession.insert(nameSpace + ".write_question");
	}

	@Override
	public Question question_detail(int qNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".question_detail");
	}

	@Override
	public Answer getAnswer(int qNo) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getAnswer");
	}

	@Override
	public int answer_complete(int qNo) throws Exception {
		return sqlSession.update(nameSpace + ".answer_complete");
	}

	@Override
	public int write_answer(Answer answer) throws Exception {
		return sqlSession.insert(nameSpace + ".write_answer");
	}

}
