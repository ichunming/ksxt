/**
 * @author ming
 * @date 2017年2月21日 下午12:33:35
 */
package com.ksxt.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksxt.core.helper.Message;
import com.ksxt.model.Kecheng;
import com.ksxt.service.IKechengService;
import com.ksxt.vo.KechengVo;

@Controller
@RequestMapping("/kc")
public class KechengController {
	private static final Logger logger = LoggerFactory.getLogger(KechengController.class);
	
	@Autowired
	private IKechengService kechengService; 
	
	@RequestMapping("mgr/view")
	public String view(Model model) {
		logger.debug("view kecheng request...");
		
		// get kecheng info
		logger.debug("get kecheng info...");
		List<Kecheng> kcList = kechengService.getAllKechengs();
		
		if(kcList.size() == 0) {
			logger.debug("无课程数据");
			model.addAttribute("msg", new Message("无课程数据"));
		} else {
			// convert to vo
			List<KechengVo> kcVos = kechengService.convert2Vo(kcList);
			model.addAttribute("kcList", kcVos);
		}
		
		return "kecheng-mgr";
	}
	
	@RequestMapping("mgr/delete")
	public String delete(Integer kcId) {
		logger.debug("delete kecheng request...");
		logger.debug("parameter:kcId[" + kcId + "]");
		
		// delete kecheng
		logger.debug("delete kecheng...");
		kechengService.delete(kcId);
		
		return "redirect:/kc/mgr/view";
	}
	
	@RequestMapping("mgr/update")
	public String update(KechengVo kcVo) {
		logger.debug("delete kecheng request...");
		logger.debug("parameter:kcId[" + kcVo.getKcId() + "], title[" + kcVo.getTitle() + 
				"], orderId[" + kcVo.getOrderId() + "], status[" + kcVo.getStatus() +
				"], danxuanCk[" + kcVo.getDanxuanCk() + "], duoxuanCk[" + kcVo.getDuoxuanCk() + 
				"], panduanCk[" + kcVo.getPanduanCk() + "], anlifenxiCk[" + kcVo.getAnlifenxiCk() +
				"], jisuanfenxiCk[" + kcVo.getJisuanfenxiCk()+ "]");
		
		// update
		kechengService.update(kcVo);
		
		return "redirect:/kc/mgr/view";
	}
	
	@RequestMapping("mgr/save")
	public String save(KechengVo kcVo) {
		logger.debug("save kecheng request...");
		logger.debug("parameter:kcId[" + kcVo.getKcId() + "], title[" + kcVo.getTitle() + 
				"], orderId[" + kcVo.getOrderId() + "], status[" + kcVo.getStatus() +
				"], danxuanCk[" + kcVo.getDanxuanCk() + "], duoxuanCk[" + kcVo.getDuoxuanCk() + 
				"], panduanCk[" + kcVo.getPanduanCk() + "], anlifenxiCk[" + kcVo.getAnlifenxiCk() +
				"], jisuanfenxiCk[" + kcVo.getJisuanfenxiCk()+ "]");
		
		// save
		kechengService.save(kcVo);
		
		return "redirect:/kc/mgr/view";
	}
}