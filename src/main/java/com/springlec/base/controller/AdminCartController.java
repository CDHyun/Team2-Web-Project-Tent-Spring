package com.springlec.base.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Cart;
import com.springlec.base.model.Purchase;
import com.springlec.base.service.AdminCartService;
import com.springlec.base.service.PurchaseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminCartController {

	
	@Autowired
	AdminCartService adminCartService;
	@Autowired
	PurchaseService purchaseService;
	
	//카트 리스트 불러오기
	@RequestMapping("/admincartSelect")
	public String selectlist(HttpServletRequest request,HttpSession session, Model model) throws Exception{
		List<Cart> selectlist = adminCartService.cartSelect((String)session.getAttribute("SUID"));
		model.addAttribute("ITEM", selectlist);
		session.setAttribute("ITEM", selectlist);
		
		int total = adminCartService.countSum((String)session.getAttribute("SUID"));
		model.addAttribute("ITEMTOTAL", total);
		
		List<Cart> recommendind = adminCartService.recommend();
		model.addAttribute("recommend", recommendind);
		
		return "admin/adminCart";
	}
	
	
	// 상품디테일에서 카트로 상품추가
	@RequestMapping("/cart")
	public String addCart(HttpServletRequest request,Model model, HttpSession session ) throws Exception{
		adminCartService.addCart((String)session.getAttribute("SUID"),Integer.parseInt(request.getParameter("pCode")),
				Integer.parseInt(request.getParameter("pcQty")),request.getParameter("pColor") );
		
		return "redirect:admincartSelect";
	}
	
	
	
	// 카트항목삭제
	@RequestMapping("/adminCartDelete")
	public String deleteCart(HttpServletRequest request, Model model) throws Exception{
		adminCartService.deleteCart(Integer.parseInt(request.getParameter("cNo")));
		return "redirect:admincartSelect";
	}
	
	
	
	@RequestMapping("/carttopurchase")
	public String showUserInfo(HttpServletRequest request,Model model, HttpSession session) throws Exception{
		String[] cNoArray = request.getParameterValues("cNoArrayInput");
		  String cNoArrayString = Arrays.toString(cNoArray);
		  System.out.println(cNoArrayString);
		  model.addAttribute("cNoArrayString",cNoArrayString );
		  session.setAttribute("cNoArrayString",cNoArrayString);
		
		  
		 
		 
		 
		  Purchase selectlist = purchaseService.purchaseInfoDao((String)session.getAttribute("SUID"));
	       model.addAttribute("user", selectlist);
		 
	     
	       
	      
	    	
	    	
	    	
		  return "purchase/purchase_info";
	}
	
	@RequestMapping("/cart_list")
	public String showCart(HttpServletRequest request,HttpSession session, Model model) throws Exception{
		List<Cart> cartlist = adminCartService.cartSelect((String)session.getAttribute("SUID"));
		model.addAttribute("ITEM", cartlist);
		session.setAttribute("ITEM", cartlist);
		
		int total = adminCartService.countSum((String)session.getAttribute("SUID"));
		model.addAttribute("ITEMTOTAL", total);
		session.setAttribute("ITEMTOTAL", total);
		
		List<Cart> recommendind = adminCartService.recommend();
		model.addAttribute("recommend", recommendind);
		
		return "admin/adminCart";
	}
	 
	// 위시리스트 헤더 보여주기
	@RequestMapping("/wishlistselect")
	public String showWishlist(HttpServletRequest request,HttpSession session, Model model) throws Exception{
		List<Cart> dto = adminCartService.wishlistSelect((String)session.getAttribute("SUID"));
		model.addAttribute("wishlist", dto);
		return ("cart/wishlist");
	}
	
	
	@RequestMapping("/wishlists")
	public String wish(HttpServletRequest request,HttpSession session, Model model) throws Exception{
		adminCartService.insertWish((String)session.getAttribute("SUID"),Integer.parseInt(request.getParameter("pCode")),request.getParameter("pColor"));
		
		return ("redirect:wishlistselect");
		
	}
	
	
	@RequestMapping("/wishlistInsertToCart")
	public String wishToCart(HttpServletRequest request) throws Exception{
		adminCartService.wishCart(request.getParameter("wNo"));
		
		return ("redirect:wishlistselect");
	}
	
	
	@RequestMapping("/wishlistDeletes")
	public String deleteWish(HttpServletRequest request) throws Exception{
		adminCartService.deleteWish(request.getParameter("wNo"));
		
		return ("redirect:wishlistselect");
	}


	@RequestMapping("/increaseQty")
	@ResponseBody
	public int increaseQty(HttpServletRequest request) throws Exception {
		int result = adminCartService.increaseQty(Integer.parseInt(request.getParameter("cNo")));
		return result;
	}

	@RequestMapping("/decreaseQty")
	@ResponseBody
	public int decreaseQty(HttpServletRequest request) throws Exception {
		int result = adminCartService.decreaseQty(Integer.parseInt(request.getParameter("cNo")));
		return result;
	}





}
