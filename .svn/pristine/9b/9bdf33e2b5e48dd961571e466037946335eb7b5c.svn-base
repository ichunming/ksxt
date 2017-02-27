/**
 * @author ming
 * @date 2017年2月16日 下午3:01:11
 */
package com.ksxt.service;

import java.util.List;

import com.ksxt.common.helper.KaoshiInfo;
import com.ksxt.model.KaoshiLog;
import com.ksxt.model.Shijuan;
import com.ksxt.vo.BaseResult;

public interface IKaoshiService {
	/**
	 * 根据课程ID取得试卷列表
	 * @param kcId
	 * @return
	 */
	public List<Shijuan> getSJsByKcId(Integer kcId);
	
	/**
	 * 根据试题ID取得试题信息
	 * @param stId
	 * @return
	 */
	public BaseResult getShitiInfo(Long stId);
	
	/**
	 * 取得当前版本
	 * @param uid
	 * @param sjId
	 * @return
	 */
	public Integer getCurVersion(Long uid, Long sjId);
	
	/**
	 * 提交考试结果
	 * @param uid
	 * @param answer
	 * @param info
	 */
	public void commitAnswer(Long uid, String userAnswer, KaoshiInfo info);
	
	/**
	 * 取得考试结果
	 * @param uid
	 * @param sjId
	 * @return
	 */
	public BaseResult getResult(Long uid, Long sjId);
	
	/**
	 * 取得第一道试题ID
	 * @param sjId
	 * @return
	 */
	public Long getFirstStId(Long sjId);
	
	/**
	 * 取得考试记录
	 * @param uid
	 * @param info
	 * @return
	 */
	public BaseResult getKaoshiLog(Long uid, KaoshiInfo info);
}
