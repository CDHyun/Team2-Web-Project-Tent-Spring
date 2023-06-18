package com.springlec.base.model;

public class Notice {
	
	/* Field */
	int nNo;
	String aid;
	int nCgNo;
	String nTitle;
	String nContent;
	String nInsertDate;
	String nUpdateDate;
	String nDeleteDate;
	int nViewCount;
	boolean nDeleted;
	
	/* Contructor */
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int nNo, String aid, int nCgNo, String nTitle, String nContent, String nInsertDate,
			String nUpdateDate, String nDeleteDate, int nViewCount, boolean nDeleted) {
		super();
		this.nNo = nNo;
		this.aid = aid;
		this.nCgNo = nCgNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nInsertDate = nInsertDate;
		this.nUpdateDate = nUpdateDate;
		this.nDeleteDate = nDeleteDate;
		this.nViewCount = nViewCount;
		this.nDeleted = nDeleted;
	}

	/* getter & setter */
	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
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

	public String getnInsertDate() {
		return nInsertDate;
	}

	public void setnInsertDate(String nInsertDate) {
		this.nInsertDate = nInsertDate;
	}

	public String getnUpdateDate() {
		return nUpdateDate;
	}

	public void setnUpdateDate(String nUpdateDate) {
		this.nUpdateDate = nUpdateDate;
	}

	public String getnDeleteDate() {
		return nDeleteDate;
	}

	public void setnDeleteDate(String nDeleteDate) {
		this.nDeleteDate = nDeleteDate;
	}

	public int getnViewCount() {
		return nViewCount;
	}

	public void setnViewCount(int nViewCount) {
		this.nViewCount = nViewCount;
	}

	public boolean isnDeleted() {
		return nDeleted;
	}

	public void setnDeleted(boolean nDeleted) {
		this.nDeleted = nDeleted;
	}
	
	
	
	
}	// End Class
