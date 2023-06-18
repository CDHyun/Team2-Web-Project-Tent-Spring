package com.springlec.base.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartFile;


import com.springlec.base.model.Admin;
import com.springlec.base.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	
	@Autowired
	AdminService adminService;
	
	
	
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
	
		
		// 관리자 상품등록페이지 보여주기 
		@RequestMapping("/writeForm")
		public String writeview() throws Exception{
			return "admin/adminProductInsert";
		}
	
		//  관리자 상품등록 
		@Value("${upload.path}")
		private String uploadPath;
		@RequestMapping("/adminInsert")
		public String insert(
				@RequestParam("file") MultipartFile file,
                @RequestParam("file1") MultipartFile file1,
                @RequestParam("pName") String pName,
                @RequestParam("pBrandName") String pBrandName,
                @RequestParam("pPrice") int pPrice,
                @RequestParam("cgNo") int cgNo,
                @RequestParam("pCode") int pCode,
                @RequestParam("pColor") String pColor,
                @RequestParam("pStock") int pStock,
                @RequestParam("pfNo") int pfNo,
                Model model) throws Exception {
			
			
			// 파일 업로드 처리 로직
			String pfName =  file.getOriginalFilename();
			String pfRealName =  file.getOriginalFilename();
			// 파일 업로드 처리 로직 작성

			String pfHoverName =  file1.getOriginalFilename();
			String pfHoverRealName = file1.getOriginalFilename(); 
			// 파일 업로드 처리 로직 작성

			// 파일 저장
			File destFile = new File(pfRealName);
			file.transferTo(destFile);

			File destFile1 = new File(pfHoverRealName);
			file1.transferTo(destFile1);


			
		     
		
				adminService.insert(pName, pBrandName, pPrice, cgNo, pCode, pStock, pColor, pfNo);
				adminService.uploadFile(pfName, pfRealName, pfHoverName, pfHoverRealName, pCode);
				
				
			
			
				return "redirect:adminindex";	
					
		}
		
		
		
	
		//관리자 상품수정 공유페이지
		@RequestMapping("/adminUpdate")
		public String sharelist(Model model) throws Exception{
			List<Admin> selectlist = adminService.selectlist();
			model.addAttribute("list", selectlist);
			return "admin/adminProductShare";
		}
		
	
		// 상품 수정에서 하나의 상품보여주기
		@RequestMapping("/adminProductDetail")
		public String contentView(HttpServletRequest request, Model model) throws Exception{
			Admin dto = adminService.contentviewDao(Integer.parseInt(request.getParameter("pCode")),request.getParameter("pColor"));
			model.addAttribute("content_view", dto);
			return "admin/adminProductUpdate";
		}

		// 상품수정 
		//@RequestMapping("/adminUpdateAction")
		

		// 상품 삭제
		@RequestMapping("/adminDeleteAction")
		public String deleteProduct(HttpServletRequest request, Model model) throws Exception{
			adminService.deleteProduct(Integer.parseInt(request.getParameter("pCode")),request.getParameter("pColor"));
			return "redirect:adminUpdate";
		}
		
		// 주문처리
		@RequestMapping("/adminpurchaseCheck")
		public String statusCheck(Model model) throws Exception{
			List<Admin> status = adminService.statusCheck();
			model.addAttribute("check", status);
			return "admin/adminPurchaseStatus";
		}

		// 주문상태 변경
		@RequestMapping("/adminStatusChange")
		public String changeStatus(HttpServletRequest request, Model model) throws Exception{
			adminService.changeStatus(Integer.parseInt(request.getParameter("pcNo")), Integer.parseInt(request.getParameter("pcStatus")));
			return "redirect:adminpurchaseCheck";
		}

		
		// 고객관리
		@RequestMapping("/adminNotice")
		public String customer(Model model) throws Exception{
			List<Admin> customerManage = adminService.customer();
			model.addAttribute("list", customerManage);
			
			List<Admin> faqManage = adminService.faq();
			model.addAttribute("FAQ", faqManage);
			
			
			return "admin/adminNoticeBoard";
		}













}
