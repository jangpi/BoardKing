package com.jangjin.vo;

public class PushVO {
	private int bno;
	private int pushNo;
	private String userId;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getPushNo() {
		return pushNo;
	}
	public void setPushNo(int pushNo) {
		this.pushNo = pushNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "PushVO [bno=" + bno + ", pushNo=" + pushNo + ", userId=" + userId + "]";
	}
	
	
}
