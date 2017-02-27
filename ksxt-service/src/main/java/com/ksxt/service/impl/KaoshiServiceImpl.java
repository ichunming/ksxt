/**
 * @author ming
 * @date 2017年2月16日 下午3:11:33
 */
package com.ksxt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksxt.common.constant.ErrorCode;
import com.ksxt.common.helper.KaoshiInfo;
import com.ksxt.common.util.DateUtil;
import com.ksxt.common.util.StringUtil;
import com.ksxt.core.exception.ApplicationException;
import com.ksxt.dao.AnlifenxiDao;
import com.ksxt.dao.AnlifenxiSubDao;
import com.ksxt.dao.DanxuanDao;
import com.ksxt.dao.DuoxuanDao;
import com.ksxt.dao.JisuanfenxiDao;
import com.ksxt.dao.KaoshiLogDao;
import com.ksxt.dao.PanduanDao;
import com.ksxt.dao.ShijuanDao;
import com.ksxt.dao.ShitiDao;
import com.ksxt.model.Anlifenxi;
import com.ksxt.model.AnlifenxiSub;
import com.ksxt.model.KaoshiLog;
import com.ksxt.model.Shijuan;
import com.ksxt.model.Shiti;
import com.ksxt.service.IKaoshiService;
import com.ksxt.vo.AnlifenxiOutput;
import com.ksxt.vo.BaseResult;

@Service
public class KaoshiServiceImpl implements IKaoshiService {
	private static Logger logger = LoggerFactory.getLogger(KaoshiServiceImpl.class);
	
	@Autowired
	private ShijuanDao shijuanDao;
	
	@Autowired
	private ShitiDao shitiDao;
	
	@Autowired
	private DanxuanDao danxuanDao;
	
	@Autowired
	private DuoxuanDao duoxuanDao;
	
	@Autowired
	private PanduanDao panduanDao;
	
	@Autowired
	private AnlifenxiDao anlifenxiDao;
	
	@Autowired
	private JisuanfenxiDao jisuanfenxiDao;

	@Autowired
	private KaoshiLogDao kaoshiLogDao;
	
	@Autowired
	private AnlifenxiSubDao anlifenxiSubDao;
	
	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getSJsByKcId(java.lang.Integer)
	 */
	@Override
	public List<Shijuan> getSJsByKcId(Integer kcId) {
		// get shijuan list by kc id
		logger.debug("get shijuan list by kecheng id...");
		
		return shijuanDao.getSJsByKcId(kcId);
	}

	private Map<String , Object> getSTAndTM(Long stId) {
		Map<String, Object> result = new HashMap<String, Object>();
		// get shiti
		logger.debug("get shi ti...");
		Shiti shiti = shitiDao.select(stId);
		result.put("st", shiti);
		
		// get timu
		logger.debug("get ti mu...");
		switch(shiti.getTxId()) {
		case 1:
			// danxuan
        	result.put("tm", danxuanDao.select(shiti.getTmId()));
        	break;
		case 2:
			// duoxuan
			result.put("tm", duoxuanDao.select(shiti.getTmId()));
			break;
		case 3:
			// panduan
			result.put("tm", panduanDao.select(shiti.getTmId()));
			break;
		case 4:
			// jisuanfenxi -- TODO
			result.put("tm", jisuanfenxiDao.select(shiti.getTmId()));
			break;
		case 5:
			// anlifenxi
			Anlifenxi anlifenxi = anlifenxiDao.select(shiti.getTmId());
			List<AnlifenxiSub> subs = anlifenxiSubDao.getSubs(shiti.getTmId());
			
			AnlifenxiOutput output = new AnlifenxiOutput();
			output.setAnlifenxi(anlifenxi);
			output.setSubs(subs);
			result.put("tm", output);
			break;
		default:
			throw new ApplicationException(ErrorCode.ERR_SYS_INTERNAL_ERROR.toString(), "无效题型");
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getShiti(java.lang.Integer)
	 */
	@Override
	public BaseResult getShitiInfo(Long stId) {
		Map<String, Object> result = getSTAndTM(stId);
		
		return new BaseResult(ErrorCode.SUCCESS, result);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getCurVersion(java.lang.Long, java.lang.Long)
	 */
	@Override
	public Integer getCurVersion(Long uid, Long sjId) {
		// get current version
		logger.debug("get current version...");
		return kaoshiLogDao.getCurVersion(uid, sjId);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#saveLog(java.lang.Long, com.ksxt.common.helper.KaoshiInfo)
	 */
	@Override
	public void commitAnswer(Long uid, String userAnswer, KaoshiInfo info) {
		// get answer
		logger.debug("get answer...");
		String answer = null;
		switch (info.getTxId()) {
		case 1:
			// danxuan
			answer = danxuanDao.select(info.getTmId()).getAnswer();
			break;
		case 2:
			// duoxuan
			answer = duoxuanDao.select(info.getTmId()).getAnswer();
        	break;
		case 3:
			// panduan
			answer = panduanDao.select(info.getTmId()).getAnswer();
        	break;
		case 4:
			// jisuanfenxi -- TODO
        	break;
		case 5:
			// anlifenxi
			List<AnlifenxiSub> subs = anlifenxiSubDao.getSubs(info.getTmId());
			answer = getAlfxAnswer(subs);
			break;
		default:
			throw new ApplicationException(ErrorCode.ERR_SYS_INTERNAL_ERROR.toString(), "无效题型");
		}
		
		// convert KaoshiInfo to KaoshiLog
		logger.debug("convert KaoshiInfo to KaoshiLog...");
		KaoshiLog log = new KaoshiLog();
		log.fromInfo(info);
		log.setAnswer(userAnswer);
		log.setUid(uid);
		log.setCreateDate(DateUtil.current());
		
		if(answer.equals(userAnswer)) {
			log.setScore(info.getScore());
		} else {
			log.setScore(new Float(0));
		}
		kaoshiLogDao.insert(log);
	}
	
	private String getAlfxAnswer(List<AnlifenxiSub> subs) {
		List<String> answers = new ArrayList<String>();
		
		for(AnlifenxiSub sub : subs) {
			answers.add(sub.getAnswer());
		}
		
		return StringUtil.toString(answers);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getResult(java.lang.Long, java.lang.Long)
	 */
	@Override
	public BaseResult getResult(Long uid, Long sjId) {
		// get kaoshi result
		logger.debug("get kaoshi result...");
		Float score = kaoshiLogDao.getScore(uid, sjId);
		
		BaseResult result = new BaseResult(ErrorCode.SUCCESS);
		result.setData(score);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getFirstStId(java.lang.Long)
	 */
	@Override
	public Long getFirstStId(Long sjId) {
		// get shijuan info
		logger.debug("get shijuan info...");
		Shijuan shijuan = shijuanDao.select(sjId);
		return shijuan.getFirstStId();
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKaoshiService#getKaoshiLog(java.lang.Long, com.ksxt.common.helper.KaoshiInfo)
	 */
	@Override
	public BaseResult getKaoshiLog(Long uid, KaoshiInfo info) {
		// get shiti info
		logger.debug("get shiti and timu info...");
		Map<String, Object> result = getSTAndTM(info.getStId());
		
		// get kaoshi log
		logger.debug("get kaoshi log...");
		KaoshiLog log = new KaoshiLog();
		log.setUid(uid);
		log.setSjId(info.getSjId());
		log.setStId(info.getStId());
		log.setVersion(info.getVersion());
		log = kaoshiLogDao.select(log);
		result.put("log", log);
		return new BaseResult(ErrorCode.SUCCESS, result);
	}
}