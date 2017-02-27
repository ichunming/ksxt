package com.ksxt.dao;

import org.apache.ibatis.annotations.Param;

import com.ksxt.model.KaoshiLog;


public interface KaoshiLogDao {
	public void insert(KaoshiLog log);
	
	public Integer getCurVersion(@Param("uid") Long uid, @Param("sjId") Long sjId);
	
	public Float getScore(@Param("uid") Long uid, @Param("sjId") Long sjId);
	
	public KaoshiLog select(KaoshiLog log);
}