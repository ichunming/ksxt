package com.ksxt.common.constant;

public enum TixingType {
	DAN_XUAN(1, "单选"),
	DUO_XUAN(2, "多选"),
	PAN_DUAN(3, "判断"),
	JI_SUAN_FEN_XI(4, "多选"),
	AN_LI_FEN_XI(5, "多选");
	
	private Integer id;
	private String desc;
	
	private TixingType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String toString() {
		return desc;
	}
}
