package com.springlec.base.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Cart;
import com.springlec.base.service.AdminCartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminCartController {

	
	@Autowired
	AdminCartService adminCartService;
	
	//카트 리스트 불러오기
	@RequestMapping("/admincartSelect")
	public String selectlist(Model model) throws Exception{
		List<Cart> selectlist = adminCartService.cartSelect();
		model.addAttribute("ITEM", selectlist);
		
		int total = adminCartService.countSum();
		model.addAttribute("ITEMTOTAL", total);
		
		List<Cart> recommendind = adminCartService.recommend();
		model.addAttribute("recommend", recommendind);
		
		return "admin/adminCart";
	}
	
	
	// 카트항목삭제
	@RequestMapping("/adminCartDelete")
	public String deleteCart(HttpServletRequest request, Model model) throws Exception{
		adminCartService.deleteCart(Integer.parseInt(request.getParameter("cNo")));
		return "redirect:admincartSelect";
	}
	
	
	
	@RequestMapping("/carttopurchase")
	public String showUserInfo(HttpServletRequest request,Model model) throws Exception{
		String[] cNoArray = request.getParameterValues("cNoArrayInput");
		  String cNoArrayString = Arrays.toString(cNoArray);
		  model.addAttribute("cNoArrayString",cNoArrayString );
		  
		  //PurchaseDao dao = new PurchaseDao();
			//ArrayList<PurchaseDto> dtos = new ArrayList<PurchaseDto>();
			//UserDao userDao = new UserDao();
		//	ArrayList<UserDto> userInfo = new ArrayList<UserDto>();
			//userInfo = userDao.userAddressInfo(uid);
		//	dtos = dao.selectUser(uid);
		
		  
		//  model.addAttribute("selectUser", dtos);
		//  model.addAttribute("address", userInfo);
		  
		  return "purchase/purchase_info";
	}
	
	
}
