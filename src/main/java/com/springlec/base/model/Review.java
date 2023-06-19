package com.springlec.base.model;

public class Review {

	/* Field */
	int rNo;
	int pcNo;
	String uid;
	String uNickName;
	int pCode;
	String pColor;
	String rTitle;
	String rContent;
	double rScore;
	String rInsertDate;
	String rUpdateDate;
	String rDeleteDate;
	boolean rDeleted;
	
	/* Constructor */
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int rNo, int pcNo, String uid, String uNickName, int pCode, String pColor, String rTitle,
			String rContent, double rScore, String rInsertDate, String rUpdateDate, String rDeleteDate,
			boolean rDeleted) {
		super();
		this.rNo = rNo;
		this.pcNo = pcNo;
		this.uid = uid;
		this.uNickName = uNickName;
		this.pCode = pCode;
		this.pColor = pColor;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rScore = rScore;
		this.rInsertDate = rInsertDate;
		this.rUpdateDate = rUpdateDate;
		this.rDeleteDate = rDeleteDate;
		this.rDeleted = rDeleted;
	}

	/* getter & setter */
	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
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

	public String getuNickName() {
		return uNickName;
	}

	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
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

	public double getrScore() {
		return rScore;
	}

	public void setrScore(double rScore) {
		this.rScore = rScore;
	}

	public String getrInsertDate() {
		return rInsertDate;
	}

	public void setrInsertDate(String rInsertDate) {
		this.rInsertDate = rInsertDate;
	}

	public String getrUpdateDate() {
		return rUpdateDate;
	}

	public void setrUpdateDate(String rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}

	public String getrDeleteDate() {
		return rDeleteDate;
	}

	public void setrDeleteDate(String rDeleteDate) {
		this.rDeleteDate = rDeleteDate;
	}

	public boolean isrDeleted() {
		return rDeleted;
	}

	public void setrDeleted(boolean rDeleted) {
		this.rDeleted = rDeleted;
	}
	
	
	
}		// End Class
