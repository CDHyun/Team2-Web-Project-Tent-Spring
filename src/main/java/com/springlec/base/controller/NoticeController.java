package com.springlec.base.controller;

/*
 23/06/18 : Notice 컨트롤러 생성.
 23/06/18 : Notice List 띄우기 구현 시작 ->
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Notice;
import com.springlec.base.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("notice_list")
	public String noticeList(HttpServletRequest request, Model model) throws Exception {
		
		List<Notice> noticeList = noticeService.noticeList();
		model.addAttribute("noticeList", noticeList);
		return "notice/notice";
	}
	
	
}	// End Class
