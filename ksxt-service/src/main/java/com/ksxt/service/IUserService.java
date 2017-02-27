/**
 * @author ming
 * @date 2017年2月7日 上午10:08:01
 */
package com.ksxt.service;

import java.util.List;

import com.ksxt.model.User;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.KsxtPageInfo;
import com.ksxt.vo.UserForm;

public interface IUserService {

	/**
	 * 用户注册
	 * @param userForm
	 */
	public BaseResult register(UserForm userForm);
	
	/**
	 * 用户登录
	 * @param userForm
	 */
	public BaseResult login(UserForm userForm, int role);
	
	/**
	 * 手机是否存在check
	 * @param mobile
	 * @return
	 */
	public boolean isMobileExist(String mobile);
	
	/**
	 * 用户名是否存在check
	 * @param username
	 * @return
	 */
	public boolean isUsernameExist(String username);
	
	/**
	 * 取得用户信息
	 * @param page
	 * @return
	 */
	public KsxtPageInfo<User> getUsers(Integer page);
	
	/**
	 * 通过用户请求
	 * @param uidStrs
	 */
	public void pass(List<String> uidStrs);
	
	/**
	 * 通过所有用户请求
	 */
	public void passAll();
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void delete(Long uid);
	
	/**
	 * 更新用户信息
	 * @param userForm
	 */
	public BaseResult update(UserForm userForm);
	
	/**
	 * 取得用户信息
	 * @param uid
	 * @return
	 */
	public User getUser(Long uid);
	
	/**
	 * 保存用户信息
	 * @param userForm
	 * @return
	 */
	public BaseResult save(UserForm userForm);
}