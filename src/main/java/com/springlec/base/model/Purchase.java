package com.springlec.base.model;

public class Purchase {


	/* User */
	String uid;							// 유저 아이디
	String uPassword;					// 유저 비밀번호
	String uName;						// 유저 이름
	String uPhone;						// 유저 전화번호
	String uEmail;						// 유저 이메일
	
	
	/* UserAddress */
	int uaNo; 							// 유저 주소 번호(1~3까지 둘 생각)
	String uaZipcode;					// 유저 우편 번호
	String uaAddress;					// 유저 주소(API가 주는 값)
	String uaDetailAddress;				// 유저 상세 주소(직접 입력)
	String uaContent;					// 유저 배송지 정보
	
	/* Product */
	int pcNo;                           //상품 주문 번호
	int pCode;                          //상품 코드
	int pPrice;                         //상품 가격
	int pcQty;                          //상품 수량
	int pStock;                         //상품 재고
	int cgNo;				            //카테고리 번호
	String pColor;						//상품 색
	String pName;						// 상품명
	String pBrandName;                  //상품 브랜드 이름
	String pcInsertDate;             //상품 주문 날짜
	String pcDeleteDate;		        //상품 주문 취소 날짜
	int pcStatus;                    //상품 주문 상태 
	String pcDM;
	String pcPay;
	
	
	/* ProductFile */
	String pfName;			// 올린 상품 이미지 이름
	String pfRealName;		// 프로젝트에 저장된 실제 파일 이름
	String pfHoverName;		// 올린 호버 이미지 이름
	String pfHoverRealName;	// 프로젝트에 저장되는 실제 호버 이미지 이름
	
	String cNo;
	int dCount;
	
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}


	
	


	public Purchase(String uid, String uEmail, int uaNo) {
		super();
		this.uid = uid;
		this.uEmail = uEmail;
		this.uaNo = uaNo;
	}






	public Purchase(String uid, String uPassword, String uName, String uPhone, String uEmail, int uaNo,
			String uaZipcode, String uaAddress, String uaDetailAddress, String uaContent, int pcNo, int pCode,
			int pPrice, int pcQty, int pStock, int cgNo, String pColor, String pName, String pBrandName,
			String pcInsertDate, String pcDeleteDate, int pcStatus, String pcDM, String pcPay, String pfName,
			String pfRealName, String pfHoverName, String pfHoverRealName) {
		super();
		this.uid = uid;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uEmail = uEmail;
		this.uaNo = uaNo;
		this.uaZipcode = uaZipcode;
		this.uaAddress = uaAddress;
		this.uaDetailAddress = uaDetailAddress;
		this.uaContent = uaContent;
		this.pcNo = pcNo;
		this.pCode = pCode;
		this.pPrice = pPrice;
		this.pcQty = pcQty;
		this.pStock = pStock;
		this.cgNo = cgNo;
		this.pColor = pColor;
		this.pName = pName;
		this.pBrandName = pBrandName;
		this.pcInsertDate = pcInsertDate;
		this.pcDeleteDate = pcDeleteDate;
		this.pcStatus = pcStatus;
		this.pcDM = pcDM;
		this.pcPay = pcPay;
		this.pfName = pfName;
		this.pfRealName = pfRealName;
		this.pfHoverName = pfHoverName;
		this.pfHoverRealName = pfHoverRealName;
		
	}






	public int getdCount() {
		return dCount;
	}






	public void setdCount(int dCount) {
		this.dCount = dCount;
	}






	public String getcNo() {
		return cNo;
	}






	public void setcNo(String cNo) {
		this.cNo = cNo;
	}






	public String getUid() {
		return uid;
	}






	public void setUid(String uid) {
		this.uid = uid;
	}






	public String getuPassword() {
		return uPassword;
	}






	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}






	public String getuName() {
		return uName;
	}






	public void setuName(String uName) {
		this.uName = uName;
	}






	public String getuPhone() {
		return uPhone;
	}






	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}






	public String getuEmail() {
		return uEmail;
	}






	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}






	public int getUaNo() {
		return uaNo;
	}






	public void setUaNo(int uaNo) {
		this.uaNo = uaNo;
	}






	public String getUaZipcode() {
		return uaZipcode;
	}






	public void setUaZipcode(String uaZipcode) {
		this.uaZipcode = uaZipcode;
	}






	public String getUaAddress() {
		return uaAddress;
	}






	public void setUaAddress(String uaAddress) {
		this.uaAddress = uaAddress;
	}






	public String getUaDetailAddress() {
		return uaDetailAddress;
	}






	public void setUaDetailAddress(String uaDetailAddress) {
		this.uaDetailAddress = uaDetailAddress;
	}






	public String getUaContent() {
		return uaContent;
	}






	public void setUaContent(String uaContent) {
		this.uaContent = uaContent;
	}






	public int getPcNo() {
		return pcNo;
	}






	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
	}






	public int getpCode() {
		return pCode;
	}






	public void setpCode(int pCode) {
		this.pCode = pCode;
	}






	public int getpPrice() {
		return pPrice;
	}






	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}






	public int getPcQty() {
		return pcQty;
	}






	public void setPcQty(int pcQty) {
		this.pcQty = pcQty;
	}






	public int getpStock() {
		return pStock;
	}






	public void setpStock(int pStock) {
		this.pStock = pStock;
	}






	public int getCgNo() {
		return cgNo;
	}






	public void setCgNo(int cgNo) {
		this.cgNo = cgNo;
	}






	public String getpColor() {
		return pColor;
	}






	public void setpColor(String pColor) {
		this.pColor = pColor;
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






	public String getPcInsertDate() {
		return pcInsertDate;
	}






	public void setPcInsertDate(String pcInsertDate) {
		this.pcInsertDate = pcInsertDate;
	}






	public String getPcDeleteDate() {
		return pcDeleteDate;
	}






	public void setPcDeleteDate(String pcDeleteDate) {
		this.pcDeleteDate = pcDeleteDate;
	}






	public int getPcStatus() {
		return pcStatus;
	}






	public void setPcStatus(int pcStatus) {
		this.pcStatus = pcStatus;
	}






	public String getPcDM() {
		return pcDM;
	}






	public void setPcDM(String pcDM) {
		this.pcDM = pcDM;
	}






	public String getPcPay() {
		return pcPay;
	}






	public void setPcPay(String pcPay) {
		this.pcPay = pcPay;
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






	
	
	
	
	
	
}
