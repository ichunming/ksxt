/**
 * @author ming
 * @date 2017年2月7日 上午10:14:11
 */
package com.ksxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksxt.common.constant.ErrorCode;
import com.ksxt.common.constant.UserRole;
import com.ksxt.common.helper.SessionInfo;
import com.ksxt.common.util.SessionUtil;
import com.ksxt.common.util.StringUtil;
import com.ksxt.core.helper.Message;
import com.ksxt.core.helper.MessageManager;
import com.ksxt.model.User;
import com.ksxt.service.IUserService;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.UserForm;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 用户注册
	 * @param userForm
	 * @return
	 */
	@RequestMapping(value = "register", method={RequestMethod.POST, RequestMethod.GET})
	public String register(UserForm userForm, Model model, HttpServletRequest request) {
		logger.debug("register request...");
		logger.debug("parameter:username[" + userForm.getUsername() + "], password[" + userForm.getPassword() + "], mobile[" + userForm.getMobile() + "]");
		
		// check parameter
		logger.debug("check parameter...");
		if(StringUtil.isEmpty(userForm.getUsername()) || StringUtil.isEmpty(userForm.getPassword()) || StringUtil.isEmpty(userForm.getMobile())) {
			return "register";
		}
		
		// register
		BaseResult result = userService.register(userForm);
		
		if(result.getCode().longValue() == ErrorCode.SUCCESS) {
			// success
			logger.debug("register success.");

			Message message = MessageManager.getMsg(ErrorCode.ERR_USER_UNAUTHEN.toString());
			message.setContent("注册成功！" + message.getContent());
			model.addAttribute("msg", message);
			return "login";
		} else {
			// fail
			logger.debug("register fail.");
			model.addAttribute("msg", MessageManager.getMsg(result.getCode().toString()));
			return "register";
		}
	}
	
	/**
	 * 用户登入
	 * @param userForm
	 * @return
	 */
	@RequestMapping(value = "login", method={RequestMethod.POST, RequestMethod.GET})
	public String login(UserForm userForm, HttpServletRequest request, Model model) {
		logger.debug("login request...");
		
		// check SessionInfo
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		/*if(null != sessionInfo && null != sessionInfo.getUid()) {
			// already login
			logger.debug("already login.");
			return "redirect:/kecheng/list";
		}*/
		
		// check parameter
		logger.debug("check parameter...");
		if((StringUtil.isEmpty(userForm.getUsername())) || StringUtil.isEmpty(userForm.getPassword())) {
			return "login";
		}
		
		// login
		logger.debug("parameter:username[" + userForm.getUsername() + "], password[" + userForm.getPassword() + "], mobile[" + userForm.getMobile() + "]");
		BaseResult result = userService.login(userForm, UserRole.USER.getCode());
		
		if(result.getCode().longValue() == ErrorCode.SUCCESS) {
			// success
			logger.debug("login success.");
			User user = (User) result.getData();
			// save SessionInfo
			logger.debug("save session info...");
			sessionInfo = new SessionInfo(user.getId(), user.getUsername(), user.getMobile());
			SessionUtil.setSessionInfo(sessionInfo, request);
			
			// save cookie -- TODO
			
			return "redirect:/kecheng/list";
		} else {
			// fail
			logger.debug("login fail.");
			model.addAttribute("msg", MessageManager.getMsg(result.getCode().toString()));
			return "login";
		}
	}
	
	/**
	 * 用户登出
	 * @return
	 */
	@RequestMapping(value = "logout", method={RequestMethod.POST, RequestMethod.GET})
	public String logout(HttpServletRequest request) {
		logger.debug("logout request...");
		SessionUtil.setSessionInfoExpired(request);
		
		return "login";
	}
}
