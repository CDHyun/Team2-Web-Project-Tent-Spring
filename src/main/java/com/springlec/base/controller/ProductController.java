package com.springlec.base.controller;
/*
 23/06/17 : 상품 리스트 구현 시작 -> 23/06/17 : 완료
 23/06/17 : 상품 상세 페이지 구현 시작 -> 23/06/17 : 완료
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Product;
import com.springlec.base.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// 상품 리스트 불러오기
	@RequestMapping("/product_list")
	public String productList(HttpServletRequest request, Model model) throws Exception {
		String query = request.getParameter("query");
		if(query == null) {
			query = "";
		}
		List<Product> productList = productService.productList(query);
		model.addAttribute("productList", productList);
		return "product/product_list";
	}
	
	// 상품 상세 페이지
	@RequestMapping("/product_detail")
	public String product_detail(HttpServletRequest request, Model model) throws Exception {
		Product productInfo = productService.product_detail(Integer.parseInt(request.getParameter("pCode")));
		model.addAttribute("product", productInfo);
		List<Product> colorList = productService.colorList(Integer.parseInt(request.getParameter("pCode")));
		model.addAttribute("colorList", colorList);
		return "product/product_detail";
	}

}	// End Class
