package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Purchase;

public class PurchaseDaoImpl implements PurchaseDao {
	
	SqlSession sqlSession; 
	public static String nameSpace = "com.springlec.base.dao.PurchaseDao";
	@Override
	public Purchase purchaseInfoDao(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".purchaseInfoDao"); 
	}
	@Override
	public List<Purchase> purchaseCheck(int pCode, int pPrice, String pName, String pfRealName, String pfHoverRealName)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseCheck"); 
	}
	@Override
	public List<Purchase> purchaseComplete(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseComplete"); 
	}
	@Override
	public void purchaseInsert(String uid, int pCode, int pcQty, String pcDM, String pColor, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".purchaseInsert"); 
	}
	@Override
	public List<Purchase> purchaseList(String uid, String uPhone, int pcNo, int pPrice, int pcQty, String pName,
			String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay, int index_no)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseList");
	}
	
	
	@Override
	public Purchase purchaseDetailList(String uid, int pcNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".purchaseDetail"); 
	}
	@Override
	public List<Purchase> getProductInfo(int pCode) throws Exception {
		return sqlSession.selectOne(nameSpace + ".getProductInfo");
	}
	@Override
	public int modifyaddress(String uid, int uaNo, String uaAddress, String uaDetailAddress, String uaZipcode,
			String uaContent) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".modify_address");
	}
	@Override
	public Purchase getPurchaseDetails(int pcQty, String pColor, int pCode, int pcNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".getPurchaseDetails"); 
		
	}
	@Override
	public void cancelPurchase(int pcNo, int pcStatus) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".cancelPurchase");
	}
	@Override
	public void purchaseDelete(int pcNo) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".purchaseDelete");
	}
	@Override
	public void increaseStock(int pStock, int pCode, String pColor) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace+".increaseStock");
	}
	@Override
	public void decreaseStock(int pStock, int pCode, String pColor) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace+".decreaseStock");
	}
	@Override
	public int itemCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".itemCount");
	}


	@Override
	public void cartInsertAction1(String uid, String cNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".cartInsertAction1") ;
	}






	@Override
	public void cartInsertAction2(String pcDM, String pcPay, int count) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".cartInsertAction2");
	}






	@Override
	public void cartInsertAction3(String cNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + ".cartInsertAction3");
	}
	
	

}
