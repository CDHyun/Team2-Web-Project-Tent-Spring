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
    public String selectlist(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        Purchase selectlist = purchaseService.purchaseInfoDao((String)session.getAttribute("SUID"));
        Purchase purchase = new Purchase();
        // 상품 상세에서 넘겨주는 것들 세션에 저장 -> 구매 정보 확인 직전에 Service 하나 돌려서 상품 정보 불러오게 하고 그 정보를 ITEM에 담아서 보여주기.
        session.removeAttribute("PCODE");
        session.removeAttribute("PCQTY");
        session.removeAttribute("PCOLOR");
        session.setAttribute("PCODE", Integer.parseInt(request.getParameter("pCode")));
        session.setAttribute("PCQTY", Integer.parseInt(request.getParameter("pcQty")));
        session.setAttribute("PCOLOR", request.getParameter("pColor"));
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
    	int pCode = (int)session.getAttribute("PCODE");
    	int pcQty = (int)session.getAttribute("PCQTY");
    	String pColor = (String)session.getAttribute("PCOLOR");
    
        List<Purchase> purchaseInfo = purchaseService.getProductInfo(pCode);
        purchaseInfo.get(0).setPcQty(pcQty);
        purchaseInfo.get(0).setpColor(pColor);
        model.addAttribute("ITEM", purchaseInfo);
        return "purchase/purchase_check";
    }

    // 주문시 주문내용 입력
    @RequestMapping("/purchaseInsert")
    public String insert(Model model) throws Exception {
        return "purchase/purchase_complete";
    }

    // 주문완성 보여주기
    @RequestMapping("/purchaseComplete")
    public String purchaseComplete(HttpServletRequest request, Model model) throws Exception {
        List<Purchase> completeList = purchaseService.purchaseComplete(request.getParameter("uid"),Integer.parseInt(request.getParameter("pcStatus")));
        model.addAttribute("complete", completeList);
        return "purchase/purchase_complete";
    }
    
    
    
    //주문상태 변경
    
    
    //재고 수량 증가
    
    
    //주문취소
    
    
    //재고 수량 차감
    
    
    //배송지변경
    
    
   
    
}
