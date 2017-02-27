/**
 * @author ming
 * @date 2017年2月16日 下午2:54:48
 */
package com.ksxt.controller;

import java.util.List;
import java.util.Map;

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
import com.ksxt.common.helper.KaoshiInfo;
import com.ksxt.common.helper.SessionInfo;
import com.ksxt.common.util.SessionUtil;
import com.ksxt.common.util.StringUtil;
import com.ksxt.core.helper.MessageManager;
import com.ksxt.model.Danxuan;
import com.ksxt.model.Duoxuan;
import com.ksxt.model.Jisuanfenxi;
import com.ksxt.model.KaoshiLog;
import com.ksxt.model.Panduan;
import com.ksxt.model.Shijuan;
import com.ksxt.model.Shiti;
import com.ksxt.service.IKaoshiService;
import com.ksxt.vo.AnlifenxiOutput;
import com.ksxt.vo.BaseResult;

@Controller
@RequestMapping("/kaoshi")
public class KaoshiController {
	private static Logger logger = LoggerFactory.getLogger(KaoshiController.class);

	@Autowired
	private IKaoshiService kaoshiService;
	
	@RequestMapping(value = "shijuan/list", method={RequestMethod.POST, RequestMethod.GET})
	public String list(Integer kcId, Model model, HttpServletRequest request) {
		logger.debug("shijuan list request...");
		logger.debug("parameter:kcId[" + kcId + "]");
		
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		KaoshiInfo ksInfo = sessionInfo.getKsInfo();
		if(null != ksInfo) {
			sessionInfo.setKsInfo(null);
		}
		
		// get shijuan list
		logger.debug("get shijuan list...");
		List<Shijuan> sjList = kaoshiService.getSJsByKcId(kcId);
		
		if(sjList.size() == 0) {
			logger.debug("shijuan not create.");
			model.addAttribute("msg", MessageManager.getMsg(ErrorCode.ERR_MGR_SJ_NOT_CREATE.toString()));
		} else {
			model.addAttribute("sjList", sjList);
		}
		
		return "shijuanList";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "shiti/get", method={RequestMethod.POST, RequestMethod.GET})
	public String getShiti(@RequestParam(value="stId", required=false, defaultValue="") Long stId, Model model, HttpServletRequest request) {
		logger.debug("shiti get request...");
		logger.debug("parameter:stId[" + stId + "]");
		
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		KaoshiInfo ksInfo = sessionInfo.getKsInfo();
		if(null == stId) {
			if(null == ksInfo) {
				logger.debug("request error.");
				return "common/requestError";
			}
			stId = ksInfo.getStId();
		}
		
		// get shiti
		logger.debug("get shi ti...");
		BaseResult result = kaoshiService.getShitiInfo(stId);
		Map<String, Object> data = (Map<String, Object>) result.getData();
		Shiti st = (Shiti) data.get("st");
		
		if(null == ksInfo) {
			ksInfo = new KaoshiInfo();
			ksInfo.setSjId(st.getSjId());
			ksInfo.setTxId(st.getTxId());
			ksInfo.setStId(st.getId());
			ksInfo.setScore(st.getScore());
			ksInfo.setNextId(st.getNextId());
			ksInfo.setTmId(st.getTmId());
			ksInfo.setVersion(kaoshiService.getCurVersion(sessionInfo.getUid(), ksInfo.getSjId()) + 1);
			ksInfo.setNo(1);
			
			sessionInfo.setKsInfo(ksInfo);
		} else {
			if(ksInfo.getTxId() != st.getTxId()) {
				ksInfo.setTxId(st.getTxId());
				ksInfo.setNo(1);
			} else {
				ksInfo.setNo(ksInfo.getNo() + 1);
			}
			
			ksInfo.setNextId(st.getNextId());
			ksInfo.setTmId(st.getTmId());
			ksInfo.setStId(st.getId());
			ksInfo.setScore(st.getScore());
		}
		
		model.addAttribute("no", ksInfo.getNo());
		model.addAttribute("st", st);
		
		switch (st.getTxId()) {
		case 1:
			// danxuan
			model.addAttribute("tm", (Danxuan) data.get("tm"));
        	return "danxuan";
		case 2:
			// duoxuan
			model.addAttribute("tm", (Duoxuan) data.get("tm"));
        	return "duoxuan";
		case 3:
			// panduan
			model.addAttribute("tm", (Panduan) data.get("tm"));
        	return "panduan";
		case 4:
			// jisuanfenxi -- TODO
			model.addAttribute("tm", (Jisuanfenxi) data.get("tm"));
        	return "jisuanfenxi";
		case 5:
			// anlifenxi
			model.addAttribute("tm", (AnlifenxiOutput) data.get("tm"));
			return "anlifenxi";
		default:
			return "redirect:/500";
		}
	}
	
	@RequestMapping("shiti/answer/commit")
	public String commitAnswer(Long stId, @RequestParam(required=false, defaultValue="") String answer, HttpServletRequest request) {
		logger.debug("shiti submit answer request...");
		logger.debug("parameter:stId[" + stId + "],answer[" + answer + "]");
		
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		KaoshiInfo ksInfo = sessionInfo.getKsInfo();
		
		// commit answer
		logger.debug("commit answer...");
		kaoshiService.commitAnswer(sessionInfo.getUid(), answer, ksInfo);
		
		if(null == ksInfo.getNextId()) {
			return "redirect:/kaoshi/complete";
		}
		return "redirect:/kaoshi/shiti/get?stId=" + ksInfo.getNextId();
	}
	
	@RequestMapping("complete")
	public String complete(HttpServletRequest request, Model model) {
		logger.debug("kaoshi complete request...");
		
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		KaoshiInfo ksInfo = sessionInfo.getKsInfo();
		
		// get result
		BaseResult result = kaoshiService.getResult(sessionInfo.getUid(), ksInfo.getSjId());
		
		Float score = (Float) result.getData();
		model.addAttribute("score", score);
		return "result";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("shiti/review")
	public String review(HttpServletRequest request, Model model) {
		logger.debug("kaoshi review request...");
		
		SessionInfo sessionInfo = SessionUtil.getSessionInfo(request);
		KaoshiInfo ksInfo = sessionInfo.getKsInfo();
		if(null == ksInfo.getNextId()) {
			ksInfo.setNextId(kaoshiService.getFirstStId(ksInfo.getSjId()));
			ksInfo.setNo(0);
		}
		
		BaseResult result = kaoshiService.getKaoshiLog(sessionInfo.getUid(), ksInfo);
		Map<String, Object> data = (Map<String, Object>) result.getData();
		Shiti st = (Shiti) data.get("st");
		
		if(ksInfo.getTxId() != st.getTxId()) {
			ksInfo.setTxId(st.getTxId());
			ksInfo.setNo(1);
		} else {
			ksInfo.setNo(ksInfo.getNo() + 1);
		}
		
		ksInfo.setNextId(st.getNextId());
		ksInfo.setTmId(st.getTmId());
		ksInfo.setStId(st.getId());
		ksInfo.setScore(st.getScore());
		
		model.addAttribute("no", ksInfo.getNo());
		model.addAttribute("st", st);
		model.addAttribute("log", (KaoshiLog) data.get("log"));
		
		switch (st.getTxId()) {
		case 1:
			// danxuan
			model.addAttribute("tm", (Danxuan) data.get("tm"));
        	return "danxuan";
		case 2:
			// duoxuan
			model.addAttribute("tm", (Duoxuan) data.get("tm"));
        	return "duoxuan";
		case 3:
			// panduan
			model.addAttribute("tm", (Panduan) data.get("tm"));
        	return "panduan";
		case 4:
			// jisuanfenxi -- TODO
			model.addAttribute("tm", (Jisuanfenxi) data.get("tm"));
        	return "jisuanfenxi";
		case 5:
			// anlifenxi
			model.addAttribute("tm", (AnlifenxiOutput) data.get("tm"));
			return "anlifenxi";
		default:
			return "redirect:/500";
		}
	}
}