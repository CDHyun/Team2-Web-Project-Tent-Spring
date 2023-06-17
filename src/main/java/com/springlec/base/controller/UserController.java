package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

/*
23/06/16 : User 아이디 중복 체크 구현 시작 -> 23/06/16 : 완료.
23/06/16 : User 회원가입 구현 시작 -> 23/06/16 : 완료.
23/06/16 : User 로그인 구현 시작 -> 23/06/17 : 완료.
23/06/17 : User 로그아웃 구현 시작 -> 23/06/17 : 완료.
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.User;
import com.springlec.base.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	// 회원 가입
	@RequestMapping("sign_up")
	@ResponseBody
	public int createUser(User user) throws Exception {
		return userService.signUp(user);
	}
	
	// 아이디 중복 체크
	@RequestMapping("checkDuplicateId")
	@ResponseBody
	public int checkDuplicate(HttpServletRequest request) throws Exception {
		int result = userService.checkDuplicateId(request.getParameter("uid"));
		return result;
	}
	
	// 로그인 확인
	@RequestMapping("loginCheck")
	@ResponseBody
	public int loginCheck(HttpServletRequest request) throws Exception {
		int result = userService.loginCheck(request.getParameter("uid"), request.getParameter("uPassword"));
		return result;
	}
	
	// 로그인
	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpSession session) throws Exception {
		session.setAttribute("SUID", request.getParameter("luid"));
		String userNickname = userService.getUserNickname(request.getParameter("luid"));
		session.setAttribute("SUNICKNAME", userNickname);
		return "redirect:index";
	}
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:index";
	}
	
	// 마이 페이지
	@RequestMapping("my_account")
	public String my_account(HttpSession session, Model model) throws Exception {
		String uid = (String)session.getAttribute("SUID");
		User userInfo = userService.userInfo(uid);
		model.addAttribute("user", userInfo);
		
		return "user/my_account";
	}
	
	//핸드폰 번호 변경
	@RequestMapping("user_modify_phone")
	@ResponseBody
	public int user_modify_phone(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.modify_phone((String)session.getAttribute("SUID"), request.getParameter("uPhone"));
		return result;
	}
	
	//비밀번호 확인
	@RequestMapping("passwordCheck")
	@ResponseBody
	public int passwordCheck(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.accordCheck((String)session.getAttribute("SUID"), request.getParameter("uPassword"));
		if(result == 1) {
			session.setAttribute("CONFIRM", result);
		}
		return result;
	}
	
	
	
	
	
	
	
}	// End Class
