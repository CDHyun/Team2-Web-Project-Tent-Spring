package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Question;

public interface QnAService {

	// QnA 전체 질문 리스트 불러오기
	public List<Question> question_list() throws Exception;
	
	// QnA 조회수 증가
	public int increaseQuestionViewCount(int qNo) throws Exception;
	
	// QnA 작성
	public int write_question(Question question) throws Exception;
	
	
}	// End Class
