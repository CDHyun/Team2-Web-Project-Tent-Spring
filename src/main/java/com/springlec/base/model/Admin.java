package com.springlec.base.model;

import java.math.BigInteger;
import java.sql.Date;

public class Admin {
	int pCode;
	String pName;
	String pBrandName;
	int pPrice;
	Date pInsertdate;
	Date pupdatedate;
	Date pdeletedate;
	String pfName;
	String pfRealName;
	int cgNo;
	String cgName;
	String pColor;
	int pStock;
	String pfHoverName;
	String pfHoverRealName;
	String lastfile;
	// 주문처리에 필요한 변수
	int pcNo;
	String uid;
	int pcQty;
	int pcStatus;
	Date pcInsertdate;
	
	// 페이징처리위한 상품갯수
	int dCount;
	
	String wNo ;
	
	//공지사항에 필요한 변수
	String aid;
	int nCgNo;
	String nTitle;
	String nContent;
	Date nInsertdate;
	int nNo;
	
	
	
	//차트에 필요한 변수
	String dayName;
	BigInteger daySum;
	int colorSum;
	int addColor;
	
	
	// 날짜별매출에 필요한 변수
	int sum;
	int total;
	
	// cart 에 필요한 변수
	int cQty;
	int ctotal;
	int cNo;
	
	
	// 리뷰관리
	int rNo;
	String uNickName;
	String rTitle;
	String rContent;
	int rScore;
	Date rInsertDate;
	Date rUpdateDate;
	Date rDeleteDate;
	int rDeleted;
	
	
	// qna
	int qNo;
	int qCgNo;
	String qTitle;
	String qContent;
	Date qInsertDate;
	Date qUpdateDate;
	Date qDeleteDate;
	int qDeleted;
	
	
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Admin(int pCode, String pName, String pBrandName, int pPrice, Date pInsertdate) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pBrandName = pBrandName;
		this.pPrice = pPrice;
		this.pInsertdate = pInsertdate;
	}

	//공지등록
	public Admin( String nTitle, String nContent, Date nInsertdate, String aid,int nCgNo) {
	super();
	this.nCgNo = nCgNo;
	this.aid = aid;
	this.nTitle = nTitle;
	this.nContent = nContent;
	this.nInsertdate = nInsertdate;
}

	//리뷰관리
	public Admin(int rNo, int pCode,int pcNo, int rScore, String uid,  String pColor,  String uNickName, String rTitle,
			String rContent,  Date rInsertDate) {
		super();
		this.pCode = pCode;
		this.pColor = pColor;
		this.pcNo = pcNo;
		this.uid = uid;
		this.rNo = rNo;
		this.uNickName = uNickName;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rScore = rScore;
		this.rInsertDate = rInsertDate;
	}

	public Admin(int pCode, String pBrandName,String pName, int pPrice, String pColor, int pStock, String lastfile) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pBrandName = pBrandName;
		this.pPrice = pPrice;
		this.pColor = pColor;
		this.pStock = pStock;
		this.lastfile = lastfile;
	}



	public Admin(int pCode, String pName, String pBrandName, int pPrice, Date pInsertdate, Date pupdatedate,
			Date pdeletedate, String pfName, String pfRealName, int cgNo, String cgName, String pColor, int pStock,
			String pfHoverName, String pfHoverRealName, int pcNo, String uid, int pcQty, int pcStatus,
			Date pcInsertdate, String wNo, String aid, int nCgNo, String nTitle, String nContent, Date nInsertdate,
			int nNo, String dayName, BigInteger daySum, int colorSum, int addColor, int sum, int total, int cQty, int ctotal,
			int cNo) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pBrandName = pBrandName;
		this.pPrice = pPrice;
		this.pInsertdate = pInsertdate;
		this.pupdatedate = pupdatedate;
		this.pdeletedate = pdeletedate;
		this.pfName = pfName;
		this.pfRealName = pfRealName;
		this.cgNo = cgNo;
		this.cgName = cgName;
		this.pColor = pColor;
		this.pStock = pStock;
		this.pfHoverName = pfHoverName;
		this.pfHoverRealName = pfHoverRealName;
		this.pcNo = pcNo;
		this.uid = uid;
		this.pcQty = pcQty;
		this.pcStatus = pcStatus;
		this.pcInsertdate = pcInsertdate;
		this.wNo = wNo;
		this.aid = aid;
		this.nCgNo = nCgNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nInsertdate = nInsertdate;
		this.nNo = nNo;
		this.dayName = dayName;
		this.daySum = daySum;
		this.colorSum = colorSum;
		this.addColor = addColor;
		this.sum = sum;
		this.total = total;
		this.cQty = cQty;
		this.ctotal = ctotal;
		this.cNo = cNo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	























	//



	



	public void setColorSum(int colorSum) {
		this.colorSum = colorSum;
	}

	
	


	public int getColorSum() {
		return colorSum;
	}
	
	
	public String getCgName() {
		return cgName;
	}






	public void setCgName(String cgName) {
		this.cgName = cgName;
	}






	public int getpCode() {
		return pCode;
	}


	public void setpCode(int pCode) {
		this.pCode = pCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpBrandName() {
		return pBrandName;
	}


	public void setpBrandName(String pBrandName) {
		this.pBrandName = pBrandName;
	}


	public int getpPrice() {
		return pPrice;
	}


	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public Date getpInsertdate() {
		return pInsertdate;
	}


	public void setpInsertdate(Date pInsertdate) {
		this.pInsertdate = pInsertdate;
	}


	public Date getPupdatedate() {
		return pupdatedate;
	}


	public void setPupdatedate(Date pupdatedate) {
		this.pupdatedate = pupdatedate;
	}


	public Date getPdeletedate() {
		return pdeletedate;
	}


	public void setPdeletedate(Date pdeletedate) {
		this.pdeletedate = pdeletedate;
	}


	public String getPfName() {
		return pfName;
	}


	public void setPfName(String pfName) {
		this.pfName = pfName;
	}


	public String getPfRealName() {
		return pfRealName;
	}


	public void setPfRealName(String pfRealName) {
		this.pfRealName = pfRealName;
	}


	public int getCgNo() {
		return cgNo;
	}


	public void setCgNo(int cgNo) {
		this.cgNo = cgNo;
	}


	public String getcgName() {
		return cgName;
	}


	public void setcgName(String cgName) {
		this.cgName = cgName;
	}


	public String getpColor() {
		return pColor;
	}


	public void setpColor(String pColor) {
		this.pColor = pColor;
	}


	public int getpStock() {
		return pStock;
	}


	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	
	
	public int getPcNo() {
		return pcNo;
	}


	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public int getPcQty() {
		return pcQty;
	}


	public void setPcQty(int pcQty) {
		this.pcQty = pcQty;
	}


	public int getPcStatus() {
		return pcStatus;
	}


	public void setPcStatus(int pcStatus) {
		this.pcStatus = pcStatus;
	}


	public Date getPcInsertdate() {
		return pcInsertdate;
	}


	public void setPcInsertdate(Date pcInsertdate) {
		this.pcInsertdate = pcInsertdate;
	}


	public int getdCount() {
		return dCount;
	}



	public void setdCount(int dCount) {
		this.dCount = dCount;
	}



	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public int getnCgNo() {
		return nCgNo;
	}


	public void setnCgNo(int nCgNo) {
		this.nCgNo = nCgNo;
	}


	public String getnTitle() {
		return nTitle;
	}


	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}


	public String getnContent() {
		return nContent;
	}


	public void setnContent(String nContent) {
		this.nContent = nContent;
	}


	public Date getnInsertdate() {
		return nInsertdate;
	}


	public void setnInsertdate(Date nInsertdate) {
		this.nInsertdate = nInsertdate;
	}


	public int getnNo() {
		return nNo;
	}


	public void setnNo(int nNo) {
		this.nNo = nNo;
	}


	public String getDayName() {
		return dayName;
	}


	public void setDayName(String dayName) {
		this.dayName = dayName;
	}


	public BigInteger getDaySum() {
		return daySum;
	}


	public void setDaySum(BigInteger daySum) {
		this.daySum = daySum;
	}


	


	

	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getPfHoverName() {
		return pfHoverName;
	}


	public void setPfHoverName(String pfHoverName) {
		this.pfHoverName = pfHoverName;
	}


	public String getPfHoverRealName() {
		return pfHoverRealName;
	}


	public void setPfHoverRealName(String pfHoverRealName) {
		this.pfHoverRealName = pfHoverRealName;
	}


	public int getAddColor() {
		return addColor;
	}


	public void setAddColor(int addColor) {
		this.addColor = addColor;
	}


	public int getcQty() {
		return cQty;
	}


	public void setcQty(int cQty) {
		this.cQty = cQty;
	}


	public int getCtotal() {
		return ctotal;
	}


	public void setCtotal(int ctotal) {
		this.ctotal = ctotal;
	}


	public int getcNo() {
		return cNo;
	}


	public void setcNo(int cNo) {
		this.cNo = cNo;
	}


	public String getwNo() {
		return wNo;
	}


	public void setwNo(String wNo) {
		this.wNo = wNo;
	}



	public String getLastfile() {
		return lastfile;
	}



	public void setLastfile(String lastfile) {
		this.lastfile = lastfile;
	}



	public int getrNo() {
		return rNo;
	}



	public void setrNo(int rNo) {
		this.rNo = rNo;
	}



	public String getuNickName() {
		return uNickName;
	}



	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}



	public String getrTitle() {
		return rTitle;
	}



	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}



	public String getrContent() {
		return rContent;
	}



	public void setrContent(String rContent) {
		this.rContent = rContent;
	}



	public int getrScore() {
		return rScore;
	}



	public void setrScore(int rScore) {
		this.rScore = rScore;
	}



	public Date getrInsertDate() {
		return rInsertDate;
	}



	public void setrInsertDate(Date rInsertDate) {
		this.rInsertDate = rInsertDate;
	}



	public Date getrUpdateDate() {
		return rUpdateDate;
	}



	public void setrUpdateDate(Date rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}



	public Date getrDeleteDate() {
		return rDeleteDate;
	}



	public void setrDeleteDate(Date rDeleteDate) {
		this.rDeleteDate = rDeleteDate;
	}



	public int getrDeleted() {
		return rDeleted;
	}



	public void setrDeleted(int rDeleted) {
		this.rDeleted = rDeleted;
	}



	public int getqNo() {
		return qNo;
	}



	public void setqNo(int qNo) {
		this.qNo = qNo;
	}



	public int getqCgNo() {
		return qCgNo;
	}



	public void setqCgNo(int qCgNo) {
		this.qCgNo = qCgNo;
	}



	public String getqTitle() {
		return qTitle;
	}



	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}



	public String getqContent() {
		return qContent;
	}



	public void setqContent(String qContent) {
		this.qContent = qContent;
	}



	public Date getqInsertDate() {
		return qInsertDate;
	}



	public void setqInsertDate(Date qInsertDate) {
		this.qInsertDate = qInsertDate;
	}



	public Date getqUpdateDate() {
		return qUpdateDate;
	}



	public void setqUpdateDate(Date qUpdateDate) {
		this.qUpdateDate = qUpdateDate;
	}



	public Date getqDeleteDate() {
		return qDeleteDate;
	}



	public void setqDeleteDate(Date qDeleteDate) {
		this.qDeleteDate = qDeleteDate;
	}



	public int getqDeleted() {
		return qDeleted;
	}



	public void setqDeleted(int qDeleted) {
		this.qDeleted = qDeleted;
	}

	
	
	
	
	
	
	
	
}
