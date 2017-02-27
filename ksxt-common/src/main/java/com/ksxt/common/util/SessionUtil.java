package com.ksxt.common.util;

import javax.servlet.http.HttpServletRequest;

import com.ksxt.common.constant.SystemConstant;
import com.ksxt.common.helper.SessionInfo;

public class SessionUtil {
	
	private SessionUtil(){}
	
	/**
	 * 取得用户Session
	 * @param request
	 * @return
	 */
	public static SessionInfo getSessionInfo(HttpServletRequest request){
		return (SessionInfo) request.getSession().getAttribute(SystemConstant.SESSION_INFO_NAME);
	}

	/**
	 * 设置用户Session过期
	 * @param sessionName
	 * @param request
	 */
	public static void setSessionInfoExpired(HttpServletRequest request){
		request.getSession().setAttribute(SystemConstant.SESSION_INFO_NAME, null);
	}
	
	/**
	 * 设置用户Session
	 * @param sessionInfo
	 * @param request
	 */
	public static void setSessionInfo(Object sessionInfo, HttpServletRequest request){
		request.getSession().setAttribute(SystemConstant.SESSION_INFO_NAME, sessionInfo);
	}
}
