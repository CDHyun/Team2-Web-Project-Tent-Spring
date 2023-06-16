package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Admin;
import com.springlec.base.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	
	@Autowired
	AdminService adminService;
	
	
	//관리자 상품관리 기본페이지
	@RequestMapping("/adminindex")
	public String selectlist(HttpServletRequest request, Model model) throws Exception{
		List<Admin> selectlist = adminService.selectlist();
		model.addAttribute("list", selectlist);
		return "admin/adminProductSelect";
	}
	

}
