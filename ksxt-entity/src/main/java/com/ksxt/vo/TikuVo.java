/**
 * @author ming
 * @date 2017年2月22日 下午6:32:44
 */
package com.ksxt.vo;

public class TikuVo {
	private Integer tkId;
	private String tkName;
	private Integer kcId;
	private String kcName;
	private Integer status;
	
	public Integer getTkId() {
		return tkId;
	}
	public void setTkId(Integer tkId) {
		this.tkId = tkId;
	}
	public String getTkName() {
		return tkName;
	}
	public void setTkName(String tkName) {
		this.tkName = tkName;
	}
	public Integer getKcId() {
		return kcId;
	}
	public void setKcId(Integer kcId) {
		this.kcId = kcId;
	}
	public String getKcName() {
		return kcName;
	}
	public void setKcName(String kcName) {
		this.kcName = kcName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
