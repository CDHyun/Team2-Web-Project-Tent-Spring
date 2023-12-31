package com.springlec.base.controller;

/*
 23/06/18 : Notice 컨트롤러 생성.
 23/06/18 : Notice List 띄우기 구현 시작 -> 23/06/18 : 완료. 이전에 있던 조회수 증가 오류도 수정함 (첫 공지사항의 조회수만 증가되는 버그)
 23/06/18 : 해당 카테고리만 불러오기 구현 시작 ->
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Notice;
import com.springlec.base.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	// 공지사항 전체 게시글 불러오기
	@RequestMapping("notice_list")
	public String noticeList(HttpServletRequest request, Model model) throws Exception {
		
		List<Notice> noticeList = noticeService.noticeList();
		model.addAttribute("noticeList", noticeList);
		return "notice/notice";
	}
	
	// 공지사항 조회수 증가
	@RequestMapping("increaseNoticeViewCount")
	@ResponseBody
	public int increaseNoticeViewCount(HttpServletRequest request) throws Exception {
		int result = noticeService.increaseNoticeViewCount(Integer.parseInt(request.getParameter("nNo")));
		return result;
	}
	
	// 해당하는 카테고리의 게시글만 불러오기
	@RequestMapping("notice_list_byCgNo")
	public String notice_list_byCgNo(HttpServletRequest request, Model model) throws Exception {
		List<Notice> noticeList = noticeService.notice_list_byCgNo(Integer.parseInt(request.getParameter("nCgNo")));
		model.addAttribute("noticeList", noticeList);
		return "notice/notice";
	}
	
	@RequestMapping("write_notice")
	public String write_notice(Notice notice, HttpSession session) throws Exception {
		String aid = (String)session.getAttribute("SUID");
		notice.setAid(aid);
		noticeService.write_notice(notice);
		return("redirect:notice_list");
	}
	
	
}	// End Class
