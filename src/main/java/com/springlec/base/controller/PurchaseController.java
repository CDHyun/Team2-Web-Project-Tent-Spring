package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.Purchase;
import com.springlec.base.model.User;
import com.springlec.base.service.AdminCartService;
import com.springlec.base.service.PurchaseService;
import com.springlec.base.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    AdminCartService adminCartService;
    
    @Autowired
    UserService userService;

    // 주문자 정보 불러오기
    @RequestMapping("/purchaseInfo")
    public String selectlist(HttpServletRequest request, Model model, HttpSession session) throws Exception {
       
    	String uid = (String)session.getAttribute("SUID");
		
		int pCode = Integer.parseInt(request.getParameter("pCode"));
		int pcQty = Integer.parseInt(request.getParameter("pcQty"));
		String pColor = request.getParameter("pColor");
		
	
    		
    			
    	Purchase selectlist = purchaseService.purchaseInfoDao((String)session.getAttribute("SUID"));
        // 상품 상세에서 넘겨주는 것들 세션에 저장 -> 구매 정보 확인 직전에 Service 하나 돌려서 상품 정보 불러오게 하고 그 정보를 ITEM에 담아서 보여주기.
        session.removeAttribute("PCODE");
        session.removeAttribute("PCQTY");
        session.removeAttribute("PCOLOR");
        session.setAttribute("PCODE", Integer.parseInt(request.getParameter("pCode")));
        session.setAttribute("PCQTY", Integer.parseInt(request.getParameter("pcQty")));
        session.setAttribute("PCOLOR", request.getParameter("pColor"));
        model.addAttribute("user", selectlist);
        
        // 배송지 불러오기
        List<User> addressList = userService.my_address((String)session.getAttribute("SUID"));
        model.addAttribute("address", addressList);
        
//        session.removeAttribute("ITEMTOTAL");
//		session.setAttribute("ITEMTOTAL", selectlist.getpPrice()*selectlist.getPcQty());
       
        
        
        // 바로구매할 시 ITEM에 데이터넣어두기
        List<Purchase> purchaseInfo = purchaseService.getProductInfo(pCode);
    	if(purchaseInfo.size() ==1) {
    	purchaseInfo.get(0).setPcQty(pcQty);
    	purchaseInfo.get(0).setpColor(pColor);
    	model.addAttribute("ITEM", purchaseInfo);
    	session.setAttribute("ITEM", purchaseInfo);
    	}
        
        
        
        // 카트로 왔을때 
    	String cNoArrayString = "[[]]";
		session.removeAttribute("cNoArrayString");
		session.setAttribute("cNoArrayString", cNoArrayString);
        
        
        
        
        
        
        
        
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
    	String uid =(String)session.getAttribute("SUID");
    	int pCode = (int)session.getAttribute("PCODE");
    	int pcQty = (int)session.getAttribute("PCQTY");
    	String pColor = (String)session.getAttribute("PCOLOR");
    	String pcDM = (String)session.getAttribute("PCDM");
    	String pcPay = request.getParameter("o_pay_method");
    	session.setAttribute("PCPAY", pcPay);

    	
    	
        return "purchase/purchase_check";
    }

    // 주문시 주문내용 입력
    @RequestMapping("/purchaseinsert")
    public String insert(HttpServletRequest request, Model model, HttpSession session) throws Exception {
    	String uid =(String)session.getAttribute("SUID");    	
    	String pcDM = (String)session.getAttribute("PCDM");
    	String pcPay = (String)session.getAttribute("PCPAY");
    	
    	List<Purchase> itemlength = (List<Purchase>) session.getAttribute("ITEM");
    	if(itemlength.size()==1) {
    		
    	
    	int pCode = (int)session.getAttribute("PCODE");
    	int pcQty = (int)session.getAttribute("PCQTY");
    	String pColor = (String)session.getAttribute("PCOLOR");
    	purchaseService.purchaseInsert(uid,pCode,pcQty,pcDM, pColor,pcPay);
    	purchaseService.decreaseStock(pcQty, pCode, pColor);
    	purchaseService.increaseStock(pcQty, pCode, pColor);
    	
    	}else {
	    	// 세션에서 카트 cNo배열 값 가져오기
	    	String cNoArrayString = (String) session.getAttribute("cNoArrayString");
	    	String[] values = cNoArrayString.substring(3, cNoArrayString.length() - 3).split("\",\"");
	    	
	    	for( int i = 0 ; i<values.length; i++) {
	    		System.out.println(values[i]);
	    	}
	    	
	    	int count = values.length;
	    	
	    		
		    	for (String value : values) {
		    		purchaseService.cartInsertAction1(uid, value);
		    		purchaseService.cartInsertAction2( pcDM, pcPay, count);
		    		purchaseService.cartInsertAction3(value);
				}
		
	    	
    	
    	
    	}
    	
    	
    	
    	
        return "redirect:purchaseComplete";
    }
    
    

    // 주문완성 보여주기
    @RequestMapping("/purchaseComplete")
    public String purchaseComplete(HttpServletRequest request,HttpSession session, Model model)
    throws Exception {
    	String uid =(String)session.getAttribute("SUID"); 
        List<Purchase> completeList = purchaseService.purchaseComplete(uid);
        model.addAttribute("complete", completeList);
        return "purchase/purchase_complete";
        
    }
    
    //구매내역 보여주기
    @RequestMapping("/purchase_list")
    public String orderlist(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        String uid = (String) session.getAttribute("SUID");
        String uPhone = request.getParameter("uPhone");
        int pcNo = parseIntegerParameter(request.getParameter("pcNo"));
        int pPrice = parseIntegerParameter(request.getParameter("pPrice"));
        int pcQty = parseIntegerParameter(request.getParameter("pcQty"));
        String pName = request.getParameter("pName");
        String pcInsertDate = request.getParameter("pcInsertDate");
        String pcStatus = request.getParameter("pcStatus");
        String pfRealName = request.getParameter("pfRealName");
        String pfHoverRealName = request.getParameter("pfHoverRealName");
        String pcPay = request.getParameter("pcPay");
        String vpage = request.getParameter("vpage");
        if (vpage == null) {
            vpage = "1";
        }
        int v_page = Integer.parseInt(vpage);
        int index_no = (v_page - 1) * 7;

        int dcount = purchaseService.itemCount();
        model.addAttribute("d_count", dcount);

        List<Purchase> orderlist = purchaseService.purchaseList(uid, uPhone, pcNo, pPrice, pcQty, pName, pcInsertDate, pcStatus, pfRealName, pfHoverRealName, pcPay, index_no);
        model.addAttribute("purchase", orderlist);

        return "purchase/purchase_list";
    }
    

    private int parseIntegerParameter(String parameter) {
        return parameter != null ? Integer.parseInt(parameter) : 0;
    }

    
    
    //구매 상세내역 보여주기
    @RequestMapping("/purchaseDetailView")
    public String detailview(HttpServletRequest request, HttpSession session, Model model) throws Exception {
    	String uid = (String)session.getAttribute("SUID");
        int pcNo = parseIntegerParameter(request.getParameter("pcNo"));
    
        Purchase detailview = purchaseService.purchaseDetailList(uid, pcNo);
        model.addAttribute("purchaseDetail", detailview);
        return "purchase/purchase_detailview";
    }

    
    
	 //주문상태 변경
	@RequestMapping("/purchaseDelete")
	public String deletePurchase(HttpServletRequest request) throws Exception{
		purchaseService.purchaseDelete(Integer.parseInt(request.getParameter("pcNo")));
		return "redirect:purchase_list";
	}
   
	
  
    

		
   
	// 배송지 수정
	@RequestMapping("/UserModifyAddress")
	@ResponseBody
	public int modifyaddress(HttpServletRequest request, HttpSession session) throws Exception {
		int result = purchaseService.modifyaddress((String)session.getAttribute("SUID"),
				Integer.parseInt(request.getParameter("uaNo")),
				request.getParameter("uaAddress"),
				request.getParameter("uaDetailAddress"),
				request.getParameter("uaZipcode"),
				request.getParameter("uaContent"));	
		return result;
	}
    
   
    
    





    
    
    
    
    
}