package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Purchase;

public interface PurchaseDao {
	
	
	public Purchase purchaseInfoDao(String uid) throws Exception;

	public List<Purchase> purchaseCheck(int pCode, int pPrice, String pName, String pfRealName, String pfHoverRealName) throws Exception;
	
	public List<Purchase> purchaseComplete (String uid, String pcStatus) throws Exception;
	
	public void purchaseInsert(String uid, int pCode, int pcQty, String pcDM, String pColor, String pcPay) throws Exception;
	
	public List<Purchase> purchaseList (String uid, String uPhone, int pcNo, int pPrice, int pcQty, String pName, String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay) throws Exception; 
	
	public List<Purchase> purchaseDetail(String pName, String uPhone, int pcNo, int pPrice, int pcQty, String pcInsertDate, String pfRealName, String pcPay, String pcDM, String uName ) throws Exception;
	
	
	
	
	
	
	
}//END
