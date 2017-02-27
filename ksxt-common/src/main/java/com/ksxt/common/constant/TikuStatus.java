package com.ksxt.common.constant;

public enum TikuStatus {

	UNDISTR(0, "未分配"),
	DISTRED(1, "已分配");
	
	private int code;
	private String desc;
	
	private TikuStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}

	public String toString() {
		return desc;
	}
}
