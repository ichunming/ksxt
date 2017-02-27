package com.ksxt.common.helper;

public class ExcelException extends RuntimeException {

	private static final long serialVersionUID = 7480148024830731339L;

	private String code;
	
	private String errMsg;  
	
    public ExcelException(Throwable cause) {
		super(cause);
    }
    
    public ExcelException(Throwable cause, String code) {
		super(cause);
    	this.code = code;
	}
    
    public ExcelException(String code, String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}
    
    public ExcelException(Throwable cause,String code, String errMsg) {
		this(cause);
		this.code = code;
		this.errMsg = errMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
