package com.springlec.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// Project 실행시, 메인 페이지 띄우기
	@RequestMapping("/")
	public String projectStart() {
		return "index";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
}
