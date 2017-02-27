/**
 * ErrorController
 * ming 2016/11/15
 */
package com.ksxt.controller.external;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ErrorRequestController {
	private static Logger logger = LoggerFactory.getLogger(ErrorRequestController.class);
	
	@RequestMapping(value = "/404", method = {RequestMethod.GET,RequestMethod.POST})
	public String handle404Error(HttpServletRequest request,HttpServletResponse response){						
		logger.debug("404 Error.");
		return "common/notFound";
	}
	
	@RequestMapping(value = "/500", method = {RequestMethod.GET,RequestMethod.POST})
	public String handle500Error(HttpServletRequest request,HttpServletResponse response){
		logger.debug("500 Error.");
		return "common/serverError";
	}
	
	@RequestMapping(value = "/400", method = {RequestMethod.GET,RequestMethod.POST})
	public String handle400Error(HttpServletRequest request,HttpServletResponse response){
		logger.debug("400 Error.");
		return "common/requestError";
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String handleRoot(HttpServletRequest request,HttpServletResponse response){
		logger.debug("Root Request.");
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "login", method = {RequestMethod.GET,RequestMethod.POST})
	public String handleLogin(HttpServletRequest request,HttpServletResponse response){
		logger.debug("login Request.");
		return "redirect:/user/login";
	}
}
