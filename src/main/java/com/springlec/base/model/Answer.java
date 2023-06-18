package com.springlec.base.model;

public class Answer {

	/* Field */
	// aNo, qNo, aid, aContent, aInsertDate, aUpdateDate, aDeleteDate, aDeleted
	int aNo;
	int qNo;
	String aid;
	String aContent;
	String aInsertDate;
	String aUpdateDate;
	String aDeleteDate;
	boolean aDeleted;
	
	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(int aNo, int qNo, String aid, String aContent, String aInsertDate, String aUpdateDate,
			String aDeleteDate, boolean aDeleted) {
		super();
		this.aNo = aNo;
		this.qNo = qNo;
		this.aid = aid;
		this.aContent = aContent;
		this.aInsertDate = aInsertDate;
		this.aUpdateDate = aUpdateDate;
		this.aDeleteDate = aDeleteDate;
		this.aDeleted = aDeleted;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public String getaInsertDate() {
		return aInsertDate;
	}

	public void setaInsertDate(String aInsertDate) {
		this.aInsertDate = aInsertDate;
	}

	public String getaUpdateDate() {
		return aUpdateDate;
	}

	public void setaUpdateDate(String aUpdateDate) {
		this.aUpdateDate = aUpdateDate;
	}

	public String getaDeleteDate() {
		return aDeleteDate;
	}

	public void setaDeleteDate(String aDeleteDate) {
		this.aDeleteDate = aDeleteDate;
	}

	public boolean isaDeleted() {
		return aDeleted;
	}

	public void setaDeleted(boolean aDeleted) {
		this.aDeleted = aDeleted;
	}
	
	
	
}	// End Class
