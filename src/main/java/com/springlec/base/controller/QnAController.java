package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Question;
import com.springlec.base.service.QnAService;

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
	
	
}	// End Class
