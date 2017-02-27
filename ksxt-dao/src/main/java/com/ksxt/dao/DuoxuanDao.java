package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.Duoxuan;


public interface DuoxuanDao extends GenericDao<Duoxuan, Long> {
	public void batchInsert(List<Duoxuan> duoxuans);
}