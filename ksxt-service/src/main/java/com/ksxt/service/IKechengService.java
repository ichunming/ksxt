/**
 * @author ming
 * @date 2017年2月15日 下午4:20:24
 */
package com.ksxt.service;

import java.util.List;

import com.ksxt.model.KcTxRel;
import com.ksxt.model.Kecheng;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.KechengVo;

public interface IKechengService {
	/**
	 * 取得课程List
	 * @return
	 */
	public List<Kecheng> getValidKechengs();
	
	/**
	 * 取得课程信息
	 * @param kcId
	 * @return
	 */
	public Kecheng getKecheng(Integer kcId);
	
	/**
	 * 取得所有课程
	 * @return
	 */
	public List<Kecheng> getAllKechengs();
	
	/**
	 * 转换成Vo
	 * @param kcs
	 * @return
	 */
	public List<KechengVo> convert2Vo(List<Kecheng> kcs);
	
	/**
	 * 删除课程
	 * @param kcId
	 */
	public void delete(Integer kcId);
	
	/**
	 * 更新课程
	 * @param kcVo
	 */
	public BaseResult update(KechengVo kcVo);
	
	/**
	 * 保存课程
	 * @param kcVo
	 * @return
	 */
	public BaseResult save(KechengVo kcVo);
}
