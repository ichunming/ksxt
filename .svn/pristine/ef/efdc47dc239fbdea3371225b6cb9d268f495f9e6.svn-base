/**
 * Exception Controller
 * ming 2016/11/15
 */
package com.ksxt.controller.external;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksxt.core.exception.ApplicationException;
import com.ksxt.core.exception.InvalidSessionException;
import com.ksxt.core.helper.MessageManager;

@ControllerAdvice
public class ExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(value=Exception.class)
	@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
	public String handleGeneralException(Exception ex, Model model) {
		
		if(ex instanceof ApplicationException) {
			logger.error("Application Error.", ex);
			model.addAttribute("msg", "Server Inner Error...");
			return "common/serverError";
		} else if(ex instanceof IllegalArgumentException) {
			logger.error("Illegal Argument Error.", ex);
			model.addAttribute("msg", "Request Parameter Error...");
			return "common/requestError";
		} else if(ex instanceof SQLException) {
			logger.error("Database Error.", ex);
			model.addAttribute("msg", "Datebase Server Error...");
			return "common/serverError";
		} else if(ex instanceof HttpRequestMethodNotSupportedException) {
			logger.error("Not Supported Http Request Error.", ex);
			model.addAttribute("msg", "Request Method Not Support...");
			return "common/requestError";
		} else if(ex instanceof InvalidSessionException) {
			logger.error("No Session Error.", ex);
			model.addAttribute("msg", MessageManager.getMsg(((InvalidSessionException) ex).getCode()));
			return "login";
		} else {
			logger.error("Unknown Error.", ex);
			return "common/serverError";
		}
	}
}
