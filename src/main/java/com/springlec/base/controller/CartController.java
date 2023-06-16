package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.CartDto;
import com.springlec.base.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService service;
	
	
	

	// 카트 리스트 가져오기
	@RequestMapping("/adminCart")
	public String list(Model model) throws Exception{
		List<CartDto> listDao = service.listDao();
		model.addAttribute("list", listDao);
		return "list";
	}
	
}// End
