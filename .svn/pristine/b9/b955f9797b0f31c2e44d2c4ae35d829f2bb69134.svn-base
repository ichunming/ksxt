/**
 * @author ming
 * @date 2017年2月21日 下午4:06:19
 */
package com.ksxt.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ksxt.common.constant.KcTxRelStatus;
import com.ksxt.common.util.DateUtil;
import com.ksxt.model.KcTxRel;
import com.ksxt.model.Kecheng;

public class KechengVo {
	private Integer kcId;
	private String title;
	private Integer orderId;
	private Integer status;
	private String danxuanCk;
	private String duoxuanCk;
	private String panduanCk;
	private String anlifenxiCk;
	private String jisuanfenxiCk;
	
	public Integer getKcId() {
		return kcId;
	}
	public void setKcId(Integer kcId) {
		this.kcId = kcId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDanxuanCk() {
		return danxuanCk;
	}
	public void setDanxuanCk(String danxuanCk) {
		this.danxuanCk = danxuanCk;
	}
	public String getDuoxuanCk() {
		return duoxuanCk;
	}
	public void setDuoxuanCk(String duoxuanCk) {
		this.duoxuanCk = duoxuanCk;
	}
	public String getPanduanCk() {
		return panduanCk;
	}
	public void setPanduanCk(String panduanCk) {
		this.panduanCk = panduanCk;
	}
	public String getAnlifenxiCk() {
		return anlifenxiCk;
	}
	public void setAnlifenxiCk(String anlifenxiCk) {
		this.anlifenxiCk = anlifenxiCk;
	}
	public String getJisuanfenxiCk() {
		return jisuanfenxiCk;
	}
	public void setJisuanfenxiCk(String jisuanfenxiCk) {
		this.jisuanfenxiCk = jisuanfenxiCk;
	}

	public void fromEntity(Kecheng kc) {
		kcId = kc.getId();
		title = kc.getTitle();
		orderId = kc.getOrderId();
		status = kc.getStatus();
	}
	
	public Kecheng toKecheng() {
		Kecheng kc = new Kecheng();
		Date current = DateUtil.current();
		
		kc.setId(kcId);
		kc.setOrderId(orderId);
		kc.setStatus(status);
		kc.setTitle(title);
		kc.setCreateDate(current);
		kc.setUpdateDate(current);
		
		return kc;
	}
	
	public List<KcTxRel> toKcTxRels() {
		List<KcTxRel> kcTxRels = new ArrayList<KcTxRel>();;
		KcTxRel kcTxRel = null;
		Date current = DateUtil.current();
		
		// danxuan
		kcTxRel = new KcTxRel();
		kcTxRel.setKcId(kcId);
		kcTxRel.setTxId(1);
		kcTxRel.setStatus("1".equals(danxuanCk) ? KcTxRelStatus.VALID.getCode() : KcTxRelStatus.INVALID.getCode());
		kcTxRel.setCreateDate(current);
		kcTxRel.setUpdateDate(current);
		kcTxRels.add(kcTxRel);
		
		// duoxuan
		kcTxRel = new KcTxRel();
		kcTxRel.setKcId(kcId);
		kcTxRel.setTxId(2);
		kcTxRel.setStatus("2".equals(duoxuanCk) ? KcTxRelStatus.VALID.getCode() : KcTxRelStatus.INVALID.getCode());
		kcTxRel.setCreateDate(current);
		kcTxRel.setUpdateDate(current);
		kcTxRels.add(kcTxRel);
		
		// panduan
		kcTxRel = new KcTxRel();
		kcTxRel.setKcId(kcId);
		kcTxRel.setTxId(3);
		kcTxRel.setStatus("3".equals(panduanCk) ? KcTxRelStatus.VALID.getCode() : KcTxRelStatus.INVALID.getCode());
		kcTxRel.setCreateDate(current);
		kcTxRel.setUpdateDate(current);
		kcTxRels.add(kcTxRel);
		
		// jisuanfenxi
		kcTxRel = new KcTxRel();
		kcTxRel.setKcId(kcId);
		kcTxRel.setTxId(4);
		kcTxRel.setStatus("4".equals(jisuanfenxiCk) ? KcTxRelStatus.VALID.getCode() : KcTxRelStatus.INVALID.getCode());
		kcTxRel.setCreateDate(current);
		kcTxRel.setUpdateDate(current);
		kcTxRels.add(kcTxRel);
				
		// anlifenxi
		kcTxRel = new KcTxRel();
		kcTxRel.setKcId(kcId);
		kcTxRel.setTxId(5);
		kcTxRel.setStatus("5".equals(anlifenxiCk) ? KcTxRelStatus.VALID.getCode() : KcTxRelStatus.INVALID.getCode());
		kcTxRel.setCreateDate(current);
		kcTxRel.setUpdateDate(current);
		kcTxRels.add(kcTxRel);
		
		return kcTxRels;
	}
}
