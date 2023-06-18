package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Answer;
import com.springlec.base.model.Question;

public interface QnAService {

	// QnA 전체 질문 리스트 불러오기
	public List<Question> question_list() throws Exception;
	
	// QnA 상세보기
	public Question question_detail(int qNo) throws Exception;
	
	// QnA 조회수 증가
	public int increaseQuestionViewCount(int qNo) throws Exception;
	
	// QnA 작성
	public int write_question(Question question) throws Exception;
	
	// QnA 답변 불러오기
	public Answer getAnswer(int qNo) throws Exception;
	
	// QnA 답변시 글 상태 변경하기
	public int answer_complete(int qNo) throws Exception;
	
	// QNA 답변 작성하기
	public int write_answer(Answer answer) throws Exception;
	
}	// End Class
