package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.Shijuan;

public interface ShijuanDao extends GenericDao<Shijuan, Long> {
	public List<Shijuan> getSJsByKcId(Integer kcId);
}