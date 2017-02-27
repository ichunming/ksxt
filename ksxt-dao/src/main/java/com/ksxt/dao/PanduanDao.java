package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.Panduan;

public interface PanduanDao extends GenericDao<Panduan, Long> {
	public void batchInsert(List<Panduan> panduans);
}