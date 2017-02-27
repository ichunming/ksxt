package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.AnlifenxiSub;

public interface AnlifenxiSubDao extends GenericDao<AnlifenxiSub, Long> {
	public List<AnlifenxiSub> getSubs(Long alfxId);
}