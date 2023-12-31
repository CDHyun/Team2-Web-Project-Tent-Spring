package com.springlec.base.controller;
/*
 23/06/17 : 상품 리스트 구현 시작 -> 23/06/17 : 완료
 23/06/17 : JSP 페이지 이름 변경, 상품 리스트 페이지, 검색 기능 구현 시작 -> 23/06/17 : 완료.
 23/06/17 : 상품 상세 페이지 구현 시작 -> 23/06/17 : 완료, 기존에 발생했던 페이지 깨지는 오류까지 수정.
 23/06/19 : 리뷰 리스트 구현 시작 -> 23/06/19 : 완료. 별점 표시까지 완료.
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Product;
import com.springlec.base.model.Review;
import com.springlec.base.service.ProductService;
import com.springlec.base.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ReviewService reviewService;
	
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
		int pCode = Integer.parseInt(request.getParameter("pCode"));
		Product productInfo = productService.product_detail(pCode);
		model.addAttribute("product", productInfo);
		List<Product> colorList = productService.colorList(pCode);
		model.addAttribute("colorList", colorList);
		// Review
		List<Review> reviewList = reviewService.review_list(pCode);
		model.addAttribute("reviewList", reviewList);
		double totalScore = 0;
		for (int i=0; i<reviewList.size(); i++) {
			totalScore += reviewList.get(i).getrScore();
		}
		double avgScore = totalScore / reviewList.size();
		model.addAttribute("avgScore", avgScore);
		
		return "product/product_detail";
	}

}	// End Class
