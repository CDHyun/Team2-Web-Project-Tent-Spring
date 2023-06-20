package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminCartDao;
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
	public List<Purchase> purchaseComplete(String uid) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseComplete(uid);
	}

	@Override
	public void purchaseInsert(String uid, int pCode, int pcQty, String pcDM, String pColor, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.purchaseInsert(uid, pCode, pcQty, pcDM, pColor, pcPay);
	}

	@Override
	public List<Purchase> purchaseList(String uid, String uPhone, int pcNo, int pPrice, int pcQty, String pName,
			String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseList(uid, uPhone, pcNo, pPrice, pcQty, pName, pcInsertDate, pcStatus, pfRealName, pfHoverRealName, pcPay);
	}



	@Override
	public List<Purchase> getProductInfo(int pCode) throws Exception {
		return purchaseDao.getProductInfo(pCode);
	}

	@Override
	public Purchase purchaseDetailList(String uid, int pcNo) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.purchaseDetailList(uid, pcNo);
	}

	@Override
	public int modifyaddress(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode,
			String uaContent) {
		// TODO Auto-generated method stub
		return purchaseDao.modifyaddress(uid, uaNo, uaAddress, uaDetailAddress, uaZipcode, uaContent);
	}

//	@Override
//	public Purchase getPurchaseDetails(int pcQty, String pColor, int pCode, int pcNo) {
//		// TODO Auto-generated method stub
//		return purchaseDao.getPurchaseDetails(pcQty, pColor, pCode, pcNo);
//	}
//
//	@Override
//	public void cancelPurchase(int pcNo, int pcStatus) {
//		// TODO Auto-generated method stub
//		purchaseDao.cancelPurchase(pcNo, pcStatus);
//	}

	@Override
	public void purchaseDelete(int pcNo) throws Exception {
		// TODO Auto-generated method stub
		 purchaseDao.purchaseDelete(pcNo);
	}

	@Override
	public void increaseStock(int pStock, int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.increaseStock(pStock, pCode, pColor);
	}

	@Override
	public void decreaseStock(int pStock, int pCode, String pColor) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.decreaseStock(pStock, pCode, pColor);
	}

	@Override
	public int itemCount() throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.itemCount();
	}


	@Override
	public void cartInsertAction1(String uid, String cNo) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.cartInsertAction1(uid, cNo);
	}

	@Override
	public void cartInsertAction2(String pcDM, String pcPay, int count) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.cartInsertAction2(pcDM, pcPay, count);	
		}

	@Override
	public void cartInsertAction3(String cNo) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.cartInsertAction3(cNo);
	}

	@Override
	public List<Purchase> selectlist(int index_no) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.selectlist(index_no);
	}
	



	
	
}
