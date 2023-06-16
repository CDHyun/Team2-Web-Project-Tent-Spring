package com.springlec.base.model;

public class CartDto {

	String pColor;
	String pName;
	int pPrice;
	String pfRealName;
	int pcQty;
	int cTotal;
	int cNo;
	int pCode;
	String pBrandName;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(String pColor, String pName, int pPrice, String pfRealName, int pcQty, int cTotal, int cNo,
			int pCode, String pBrandName) {
		super();
		this.pColor = pColor;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pfRealName = pfRealName;
		this.pcQty = pcQty;
		this.cTotal = cTotal;
		this.cNo = cNo;
		this.pCode = pCode;
		this.pBrandName = pBrandName;
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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getPfRealName() {
		return pfRealName;
	}

	public void setPfRealName(String pfRealName) {
		this.pfRealName = pfRealName;
	}

	public int getPcQty() {
		return pcQty;
	}

	public void setPcQty(int pcQty) {
		this.pcQty = pcQty;
	}

	public int getcTotal() {
		return cTotal;
	}

	public void setcTotal(int cTotal) {
		this.cTotal = cTotal;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpBrandName() {
		return pBrandName;
	}

	public void setpBrandName(String pBrandName) {
		this.pBrandName = pBrandName;
	}
	
	
	
	
}// End
