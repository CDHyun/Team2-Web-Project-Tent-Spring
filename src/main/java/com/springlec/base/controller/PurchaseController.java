package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Purchase;
import com.springlec.base.model.User;
import com.springlec.base.service.PurchaseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    // 주문자 정보 불러오기
    @RequestMapping("/purchaseInfo")
    public String selectlist(HttpServletRequest request, Model model) throws Exception {
        Purchase selectlist = purchaseService.PurchaseInfoDao(request.getParameter("uid"));
        model.addAttribute("user", selectlist);
        return "purchase/purchase_info";
    }

    // payment 값 저장하기
    @RequestMapping("/payment")
    public String pay(HttpServletRequest request, HttpSession session) throws Exception {
        session.setAttribute("PCDM", request.getParameter("pcDM"));
        return "purchase/payment";
    }

    @RequestMapping("/purchase_check_info")
    public String purchaseCheck(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        session.setAttribute("PCPAY", request.getParameter("pcPay"));
        List<Purchase> purchaseCheckList = purchaseService.purchaseCheck(Integer.parseInt(request.getParameter("pCode")),
                Integer.parseInt(request.getParameter("pPrice")), request.getParameter("pName"),
                request.getParameter("pfRealName"), request.getParameter("pfHoverRealName"));
        model.addAttribute("ITEM", purchaseCheckList);
        return "purchase/purchase_check_info";
    }

    // 주문시 주문내용 입력
    @RequestMapping("/purchaseInsert")
    public String insert(Model model) throws Exception {
        return "purchase_complete";
    }

    // 주문완성 보여주기
    @RequestMapping("/purchaseComplete")
    public String purchaseComplete(HttpServletRequest request, Model model) throws Exception {
        List<Purchase> completeList = purchaseService.purchaseComplete(request.getParameter("uid"),request.getParameter("pcStatus"));
        model.addAttribute("complete", completeList);
        return "purchase/purchase_complete";
    }
    
    
    
    //주문상태 변경
    
    
    //재고 수량 증가
    
    
    //주문취소
    
    
    //재고 수량 차감
    
    
    //배송지변경
    
    
   
    
}
