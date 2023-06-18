package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.PurchaseDao;
import com.springlec.base.model.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	
	@Autowired
	PurchaseDao purchaseDao;


	@Override
	public Purchase purchaseInfoDao(String uid) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseInfoDao(uid);
	}

	@Override
	public List<Purchase> purchaseCheck(int pCode, int pPrice, String pName, String pfRealName, String pfHoverRealName) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseCheck(pCode, pPrice, pName, pfRealName, pfHoverRealName);
		
	}

	@Override
	public List<Purchase> purchaseComplete(String uid, int pcStatus) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseComplete(uid, pcStatus);
	}

	@Override
	public void purchaseInsert(String uid, int pCode, int pcQty, String pcDM, String pColor, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Purchase> purchaseList(String uid, String uPhone, int pcNo, int pPrice, int pcQty, String pName,
			String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> purchaseDetail(String pName, String uPhone, int pcNo, int pPrice, int pcQty,
			String pcInsertDate, String pfRealName, String pcPay, String pcDM, String uName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> getProductInfo(int pCode) throws Exception {
		return purchaseDao.getProductInfo(pCode);
	}
	

}
