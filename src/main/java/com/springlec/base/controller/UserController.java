package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/*
23/06/16 : User 아이디 중복 체크 구현 시작 -> 23/06/16 : 완료.
23/06/16 : User 회원가입 구현 시작 -> 23/06/16 : 완료.
23/06/16 : User 로그인 구현 시작 -> 23/06/17 : 완료.
23/06/17 : User 로그아웃 구현 시작 -> 23/06/17 : 완료.
23/06/17 : 회원정보 조회(My Account), 비밀번호 확인 구현 -> 23/06/17 : 완료.
23/06/17 : 회원정보 변경(이름, 닉네임, 비밀번호, 전화번호, 이메일), 회원 탈퇴 구현 시작 -> 23/06/17 : 완료.
23/06/17 : 배송지 페이지(추가, 수정, 삭제) 구현 시작 -> 23/06/17 추가, 수정 완료 ....
23/06/19 : 카카오 로그인 구현 시작 -> 23/06/19 :  완료
23/06/20 : 이메일 인증 구현 중...
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.User;
import com.springlec.base.service.MailSendService;
import com.springlec.base.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	MailSendService mailSendService;
	
	
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
		String access_token = (String)session.getAttribute("access_token");
		if(access_token != null) {
			userService.kakao_logout(access_token);
		}
		
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
	
	//이름 변경
	@RequestMapping("modify_name")
	@ResponseBody
	public int user_modify_name(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.modify_name((String)session.getAttribute("SUID"), request.getParameter("uName"));
		return result;
	}
	
	//이메일 변경
	@RequestMapping("modify_email")
	@ResponseBody
	public int user_modify_email(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.modify_email((String)session.getAttribute("SUID"), request.getParameter("uEmail"));
		return result;
	}
	
	//이메일 변경
	@RequestMapping("modify_nickname")
	@ResponseBody
	public int user_modify_nickname(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.modify_nickname((String)session.getAttribute("SUID"), request.getParameter("uNickName"));
		if(result == 1) {
			session.removeAttribute("SUNICKNAME");
			session.setAttribute("SUNICKNAME", request.getParameter("uNickName"));
		}
		return result;
	}
	
	//회원 탈퇴
	@RequestMapping("delete_account")
	@ResponseBody
	public int user_delete_account(HttpServletRequest request, HttpSession session) throws Exception {
		int result = 0;
		int check = userService.accordCheck((String)session.getAttribute("SUID"), request.getParameter("uPassword"));
		if(check == 0) {
			result = -1;
		} else {
			check = userService.delete_account((String)session.getAttribute("SUID"));
			if(check == 0) {
				result = 0;
			} else {
				result = check;
			}
		}
		return result;
	}
	
	// 회원 배송지 페이지
	@RequestMapping("my_address")
	public String my_address(HttpSession session, Model model) throws Exception {
		List<User> addressList = userService.my_address((String)session.getAttribute("SUID"));
		model.addAttribute("addressList", addressList);
		return "user/my_address";
	}
	
	// 배송지 추가
	@RequestMapping("add_address")
	@ResponseBody
	public int addShippingAddress(HttpServletRequest request, HttpSession session) throws Exception {
		int uaNo = userService.getUaNo((String)session.getAttribute("SUID"));
		int result = userService.add_address((String)session.getAttribute("SUID"), uaNo,
				request.getParameter("uaAddress"),
				request.getParameter("uaDetailAddress"),
				request.getParameter("uaZipcode"),
				request.getParameter("uaContent"));	
		return result;
	}
	
	// 배송지 추가
	@RequestMapping("modify_address")
	@ResponseBody
	public int modify_address(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.modify_address((String)session.getAttribute("SUID"),
				Integer.parseInt(request.getParameter("uaNo")),
				request.getParameter("uaAddress"),
				request.getParameter("uaDetailAddress"),
				request.getParameter("uaZipcode"),
				request.getParameter("uaContent"));	
		return result;
	}
	
	// 배송지 삭제
	@RequestMapping("delete_address")
	@ResponseBody
	public int delete_address(HttpServletRequest request, HttpSession session) throws Exception {
		int result = userService.delete_address((String)session.getAttribute("SUID"), Integer.parseInt(request.getParameter("uaNo")));
		return result;
	}
	
	// 비밀번호 변경
	@RequestMapping("change_password")
	@ResponseBody
	public int change_password(HttpServletRequest request, HttpSession session) throws Exception {
		int result = 0;
		int check = userService.accordCheck((String)session.getAttribute("SUID"), request.getParameter("password"));
		if(check == 0) {
			result = -1;
			return result;
		} else {
			result = userService.change_password((String)session.getAttribute("SUID"), request.getParameter("changePassword"));
		}
		
		return result;
	}
	
	// 어드민 로그인
	@RequestMapping("admin_login")
	@ResponseBody
	public int admin_login(HttpServletRequest request, HttpSession session) throws Exception {
		String aid = request.getParameter("aid");
		String aPassword = request.getParameter("aPassword");
		int result = userService.admin_login(aid, aPassword);
		if(result == 1) {
			session.setAttribute("SUID", aid);
			session.setAttribute("SUNICKNAME", "관리자");
		}
		return result;
	}
	
	// 카카오 로그인
	@RequestMapping("kakao_login")
	@ResponseBody
	public int kakao_login(HttpServletRequest request, HttpSession session) throws Exception {
		String uEmail = request.getParameter("uEmail");
		int result = userService.kakao_login(uEmail);
		if(result == 1) {
			String uid = userService.getUserId(uEmail);
			session.setAttribute("SUID", uid);
			String uNickName = userService.getUserNickname(uid);
			session.setAttribute("SUNICKNAME", uNickName);
			session.setAttribute("access_token", request.getParameter("access_token"));
		}
		return result;
	}
	
	// 이메일 중복 체크
	@RequestMapping("checkDuplicateEmail")
	@ResponseBody
	public int checkDuplicateEmail(HttpServletRequest request) throws Exception {
		String uEmail = request.getParameter("uEmail");
		int result = userService.checkDuplicateEmail(uEmail);
		return result;
	}
	
	// 이메일 인증
	@RequestMapping("mailCheck")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청 : " + email);
		return mailSendService.joinEmail(email);
	}
	
	
	
	
}	// End Class
