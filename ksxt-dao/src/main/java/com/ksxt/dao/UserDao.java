package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.User;

public interface UserDao extends GenericDao<User, Long> {
	/**
	 * 插入用户信息并返回UID
	 * @param user
	 * @return
	 */
	public Long insertUseGenKey(User user);
	
	/**
	 * 通过手机号码查找用户
	 * @param mobile
	 * @return
	 */
	public User getByMobile(String mobile);
	
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * 取得用户信息
	 * @return
	 */
	public List<User> getUsers();
	
	/**
	 * 通过用户注册
	 * @param uids
	 */
	public void pass(List<Long> uids);
	
	/**
	 * 通过所有用户注册
	 */
	public void passAll();
}