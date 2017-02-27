/**
 * @author ming
 * @date 2017年2月15日 下午4:21:56
 */
package com.ksxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksxt.common.constant.ErrorCode;
import com.ksxt.common.constant.KcTxRelStatus;
import com.ksxt.dao.KcTxRelDao;
import com.ksxt.dao.KechengDao;
import com.ksxt.model.KcTxRel;
import com.ksxt.model.Kecheng;
import com.ksxt.service.IKechengService;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.KechengVo;

@Service
public class KechengServiceImpl implements IKechengService {
	private static Logger logger = LoggerFactory.getLogger(KechengServiceImpl.class);
	
	@Autowired
	private KechengDao kechengDao;
	
	@Autowired
	private KcTxRelDao kcTxRelDao;
	
	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#getKechengs()
	 */
	@Override
	public List<Kecheng> getValidKechengs() {
		// get kecheng list
		logger.debug("get kecheng list...");
		
		return kechengDao.getAllValid();
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#getKecheng(java.lang.Integer)
	 */
	@Override
	public Kecheng getKecheng(Integer kcId) {
		// get kecheng
		logger.debug("get kecheng...");
		
		return kechengDao.select(kcId);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#getAllKechengs()
	 */
	@Override
	public List<Kecheng> getAllKechengs() {
		return kechengDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#convert2Vo(java.util.List)
	 */
	@Override
	public List<KechengVo> convert2Vo(List<Kecheng> kcs) {
		// get kc-tx-rel
		logger.debug("get kecheng tixing rel...");
		List<KcTxRel> kcTxRels = kcTxRelDao.getAll();
		
		List<KechengVo> kcVos = new ArrayList<KechengVo>(kcs.size());
		KechengVo kcVo = null;
		
		for(Kecheng kc : kcs) {
			kcVo = new KechengVo();
			kcVo.fromEntity(kc);
			setTxCk(kcVo, kcTxRels);
			kcVos.add(kcVo);
		}
		return kcVos;
	}
	
	private void setTxCk(KechengVo kcVo, List<KcTxRel> kcTxRels) {
		String checked = "checked";
		for(KcTxRel kcTxRel : kcTxRels) {
			if(kcVo.getKcId().intValue() == kcTxRel.getKcId().intValue() && kcTxRel.getStatus() == KcTxRelStatus.VALID.getCode()) {
				switch (kcTxRel.getTxId()) {
				case 1:
					// danxuan
					kcVo.setDanxuanCk(checked);
					break;
				case 2:
					// duoxuan
					kcVo.setDuoxuanCk(checked);
					break;
				case 3:
					// panduan
					kcVo.setPanduanCk(checked);
					break;
				case 4:
					// jisuanfenxi
					kcVo.setJisuanfenxiCk(checked);
					break;
				case 5:
					// anlifenxi
					kcVo.setAnlifenxiCk(checked);
					break;
				default:
					break;
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer kcId) {
		// delete kc-tx-rel
		logger.debug("delete kc-tx-rel...");
		kcTxRelDao.deleteByKcId(kcId);
		
		// delete kecheng
		logger.debug("delete kecheng...");
		kechengDao.delete(kcId);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#update(com.ksxt.vo.KechengVo)
	 */
	@Override
	public BaseResult update(KechengVo kcVo) {
		// convert vo to entity
		logger.debug("convert vo to entity...");
		Kecheng kc = kcVo.toKecheng();
		List<KcTxRel> kcTxRels = kcVo.toKcTxRels();
		
		// update kecheng
		logger.debug("update kecheng...");
		kechengDao.update(kc);
		
		// update kc-tx-rel
		logger.debug("update kc-tx-rel...");
		for(KcTxRel kcTxRel : kcTxRels) {
			kcTxRelDao.update(kcTxRel);
		}
		
		return new BaseResult(ErrorCode.SUCCESS);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.IKechengService#save(com.ksxt.vo.KechengVo)
	 */
	@Override
	public BaseResult save(KechengVo kcVo) {
		// convert vo to entity
		logger.debug("convert vo to entity...");
		Kecheng kc = kcVo.toKecheng();
		
		// save kecheng
		logger.debug("save kecheng...");
		kechengDao.insertUseGenKey(kc);
		kcVo.setKcId(kc.getId());
		
		List<KcTxRel> kcTxRels = kcVo.toKcTxRels();
		// save kc-tx-rel
		logger.debug("save kc_tx_rel...");
		kcTxRelDao.insert(kcTxRels);
		
		return new BaseResult(ErrorCode.SUCCESS);
	}
}