package com.ksxt.dao;

import java.util.List;

import com.ksxt.model.Tiku;
import com.ksxt.vo.TikuParam;
import com.ksxt.vo.TikuVo;

public interface TikuDao extends GenericDao<Tiku, Integer>{

	public Integer getCurMaxId();
	
	public List<TikuVo> getList(TikuParam param);
}