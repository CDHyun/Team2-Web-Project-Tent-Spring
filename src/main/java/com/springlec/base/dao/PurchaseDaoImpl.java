package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Purchase;

public class PurchaseDaoImpl implements PurchaseDao {
	
	SqlSession sqlSession; 
	public static String nameSpace = "com.springlec.base.dao.PurchaseDao";
	@Override
	public Purchase PurchaseInfoDao(String uid) throws Exception {
		// TODO Auto-generated method stub
		return (Purchase) sqlSession.selectList(nameSpace + ".PurchaseInfoDao"); 
	}
	@Override
	public List<Purchase> purchaseCheck(int pCode, int pPrice, String pName, String pfRealName, String pfHoverRealName)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseCheck"); 
	}
	@Override
	public List<Purchase> purchaseComplete(String uid, String pcStatus) throws Exception {
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
			String pcInsertDate, String pcStatus, String pfRealName, String pfHoverRealName, String pcPay)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseList");
	}
	
	
	@Override
	public List<Purchase> purchaseDetail(String pName, String uPhone, int pcNo, int pPrice, int pcQty,
			String pcInsertDate, String pfRealName, String pcPay, String pcDM, String uName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".purchaseDetail"); 
	}



}
