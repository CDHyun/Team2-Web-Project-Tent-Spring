package com.springlec.base.controller;

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
	

}	// End Class
