package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.Kecheng;

public interface KechengDao extends GenericDao<Kecheng, Integer> {
	public List<Kecheng> getAllValid();
	
	public List<Kecheng> getAll();
	
	public void insertUseGenKey(Kecheng kc);
}