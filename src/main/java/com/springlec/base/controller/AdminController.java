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
	public String selectlist(Model model) throws Exception{
		List<Admin> selectlist = adminService.selectlist();
		model.addAttribute("list", selectlist);
		return "admin/adminProductSelect";
	}
	
	
	// 관리자 상품관리 검색
	@RequestMapping("/listQuery")
	public String querySelect(HttpServletRequest request, Model model) throws Exception{
		List<Admin> querylist = adminService.querySelect(request.getParameter("query"), request.getParameter("content"));
		model.addAttribute("list",querylist );
		return "admin/adminProductSelect";
	}

	
	// 관리자 상품등록 
	@RequestMapping("/writeForm")
	public String writeview() throws Exception{
		return "admin/adminProductInsert";
	}


	// 관리자 메인 
	@RequestMapping("/adminfirst")
	public String mainView(HttpServletRequest request, Model model) throws Exception{
		 // 날짜별 매출
		List<Admin> dtos2 = adminService.dailySale(request.getParameter("startDate"), request.getParameter("endDate"));
		model.addAttribute("SALES", dtos2);
		
		 //매출액 보여주기
		if (!dtos2.isEmpty()) {
		    Admin lastDto = dtos2.get(dtos2.size() - 1);
		    model.addAttribute("TOTAL", lastDto.getTotal());
		} else {
		    model.addAttribute("TOTAL", 0); // 또는 적절한 기본값 설정
		}
        
        
        // 막대차트데이터가져오기
        List<Admin> dtos = adminService.chart();
        model.addAttribute("summary", dtos);
        
        // JSP 페이지로 전달되는 데이터를 JavaScript 배열로 변환
        StringBuilder data = new StringBuilder();
        for (Admin dto : dtos) {
            data.append(dto.getDaySum()).append(",");
        }
        model.addAttribute("data", data.toString());
        
		return "admin/adminSummary";
	}





















}
