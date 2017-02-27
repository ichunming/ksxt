/**
 * @author ming
 * @date 2017年2月9日 下午3:58:52
 */
package com.ksxt.service;

import org.springframework.web.multipart.MultipartFile;

import com.ksxt.vo.BaseResult;
import com.ksxt.vo.TikuParam;

public interface ITikuService {
	/**
	 * check题库文件
	 * @param name
	 * @param kcId
	 * @param file
	 * @return
	 */
	public BaseResult check(String name, Integer kcId, MultipartFile file);
	
	/**
	 * 保存题库文件到本地
	 * @param tempDir
	 * @param name
	 * @param kcId
	 * @param file
	 * @return
	 */
	public BaseResult save(String tempDir, String name, Integer kcId, MultipartFile file) throws Exception;
	
	/**
	 * 查看题库文件
	 * @param param
	 * @param page
	 * @return
	 */
	public BaseResult list(TikuParam param, Integer page);
	
	/**
	 * 删除题库文件
	 * @param tikuId
	 * @return
	 */
	public BaseResult delete(Integer tikuId);
}
