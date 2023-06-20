package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Purchase;

public interface PurchaseService {

	public Purchase purchaseInfoDao(String uid) throws Exception;

	public List<Purchase> purchaseCheck(int pCode, int pPrice, String pName, String pfRealName, String pfHoverRealName) throws Exception;
	
	public List<Purchase> purchaseComplete (String uid, int pcStatus) throws Exception;
	
	public void purchaseInsert(String uid, int pCode, int pcQty, String pcDM, String pColor, String pcPay) throws Exception;
	
	public List<Purchase> purchaseList (String uid, String uPhone, int pcNo, int pPrice, int pcQty, String pName, String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay) throws Exception; 
	
	public Purchase purchaseDetailList(String uid, int pcNo) throws Exception;

	public List<Purchase> getProductInfo(int pCode) throws Exception;
	
	
	public int modifyaddress(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode, String uaContent);
}
