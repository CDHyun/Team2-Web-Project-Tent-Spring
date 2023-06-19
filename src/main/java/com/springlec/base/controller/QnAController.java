package com.springlec.base.controller;

/*
 23/06/18 : QNA 질문 리스트 불러오기 구현, 조회수 증가 기능 구현.
 23/06/18 : QNA 질문 작성 구현.
 23/06/18 : QNA 답변 작성 구현.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Answer;
import com.springlec.base.model.Question;
import com.springlec.base.service.QnAService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class QnAController {
	
	@Autowired
	QnAService qnAService;
	
	@RequestMapping("question_list")
	public String question_list(Model model) throws Exception {
		List<Question> questionList = qnAService.question_list();
		model.addAttribute("qnaList", questionList);
		return "qna/question";
	}
	
	@RequestMapping("increaseQuestionViewCount")
	@ResponseBody
	public int increaseQuestionViewCount(HttpServletRequest request) throws Exception {
		int result = qnAService.increaseQuestionViewCount(Integer.parseInt(request.getParameter("qNo")));
		return result;
	}
	
	@RequestMapping("question_detail")
	public String question_detail(HttpServletRequest request, Model model) throws Exception {
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		Question question = qnAService.question_detail(qNo);
		qnAService.increaseQuestionViewCount(qNo);
		Answer answer = qnAService.getAnswer(qNo);
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		return "qna/question_detail";
	}
	
	
	@RequestMapping("question_write_form")
	public String question_write_form() throws Exception {
		return "qna/question_write_form";
	}
	
	
	@RequestMapping("write_question")
	public String write_question(Question question, HttpSession session) throws Exception {
		question.setUid((String)session.getAttribute("SUID"));
		question.setuNickName((String)session.getAttribute("SUNICKNAME"));
		qnAService.write_question(question);
		return "redirect:question_list";
	}
	
	@RequestMapping("write_answer")
	public String write_answer(Answer answer, HttpSession session) throws Exception {
		int qNo = answer.getqNo();
		answer.setAid((String)session.getAttribute("SUID"));
		qnAService.write_answer(answer);
		return "redirect:question_detail?qNo=" + qNo;
	}
	
}	// End Class
