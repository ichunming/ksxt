/**
 * @author ming
 * @date 2017年2月9日 下午3:41:23
 */
package com.ksxt.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ksxt.common.constant.ErrorCode;
import com.ksxt.common.constant.SystemSettings;
import com.ksxt.core.helper.Message;
import com.ksxt.core.helper.MessageManager;
import com.ksxt.model.Kecheng;
import com.ksxt.model.Tiku;
import com.ksxt.service.IKechengService;
import com.ksxt.service.ITikuService;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.KsxtPageInfo;
import com.ksxt.vo.TikuParam;
import com.ksxt.vo.TikuVo;

@Controller
@RequestMapping("/tiku")
public class TikuController {
	private static final Logger logger = LoggerFactory.getLogger(TikuController.class);
	
	@Autowired
	private ITikuService tikuService;
	
	@Autowired
	private IKechengService kechengService;
	
	@RequestMapping("upload")
	public String upload() {
		return "home/upload";
	}
	
	@RequestMapping("mgr/save/{page}")
	public String save(@PathVariable("page") Integer page, String upTkName, Integer upKcId, MultipartFile file, RedirectAttributes model, HttpServletRequest request) {
		logger.debug("upload tiku request...");
		logger.debug("parameter:name[" + upTkName + "], kcId[" + upKcId + "], file[" + file.getName() + "]");
		
		BaseResult result = null;
		
		// check file
		logger.debug("check file...");
		result = tikuService.check(upTkName, upKcId, file);
		if(result.getCode().longValue() == ErrorCode.SUCCESS.longValue()) {
			// check temp dir
			logger.debug("check temp dir...");
			String tempDir = request.getSession().getServletContext().getRealPath("/") + SystemSettings.TEMP_DIR + upKcId + File.separator;
			if(!new File(tempDir).isDirectory()) {
				// create temp dir
				logger.debug("create temp dir...");
				new File(tempDir).mkdirs();
			}
			
			// save to server
			logger.debug("save to server...");
			try {
				result = tikuService.save(tempDir, upTkName, upKcId, file);
			} catch (Exception e) {
				logger.error("save file fail.");
				result = new BaseResult(ErrorCode.ERR_SYS_REQUEST_UPLOAD_FAIL);
			}
		}
		
		if(result.getCode().longValue() != ErrorCode.SUCCESS.longValue()) {
			logger.debug("fail to upload file.");
			model.addFlashAttribute("msg", MessageManager.getMsg(result.getCode().toString()));
		}
		
		return "redirect:/tiku/mgr/view/" + page;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("mgr/view/{page}")
	public String view(@RequestParam(required = false) Integer kcId, @RequestParam(required = false) Integer status, @PathVariable("page") Integer page, Model model, HttpServletRequest request) {
		logger.debug("view tiku request...");
		logger.debug("parameter:kcId[" + kcId + "], status[" + status + "], page[" + page + "]");
		
		BaseResult result = null;
		
		// get kecheng list
		logger.debug("get kecheng list...");
		List<Kecheng> kcs = kechengService.getAllKechengs();
		
		if(kcs.size() > 0) {
			// get tiku list
			logger.debug("get tiku list...");
			TikuParam param = new TikuParam();
			param.setKcId(kcId);
			param.setStatus(status);
			result = tikuService.list(param, page);
			KsxtPageInfo<TikuVo> pageInfo = (KsxtPageInfo<TikuVo>) result.getData();
			
			logger.debug("set kecheng info...");
			model.addAttribute("kcList", kcs);
			
			if(pageInfo.getList().size() > 0) {
				logger.debug("set page info...");
				model.addAttribute("pageInfo", (KsxtPageInfo<TikuVo>) result.getData());
			}
		} else {
			logger.debug("no kecheng info.");
			model.addAttribute("msg", new Message("无课程数据"));
		}
		
		return "tiku-mgr";
	}
	
	@RequestMapping("mgr/delete/{page}")
	public String delete(@PathVariable("page") Integer page, Integer tkId, Model model, HttpServletRequest request) {
		logger.debug("delete tiku request...");
		logger.debug("parameter:tikuId[" + tkId + "]");

		// delete tiku
		logger.debug("delete tiku...");
		tikuService.delete(tkId);
		
		return "redirect:/tiku/mgr/view/" + page;
	}
}