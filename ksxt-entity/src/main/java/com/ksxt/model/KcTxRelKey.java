package com.ksxt.model;

public class KcTxRelKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column kc_tx_rel.kc_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	private Integer kcId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column kc_tx_rel.tx_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	private Integer txId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column kc_tx_rel.kc_id
	 * @return  the value of kc_tx_rel.kc_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	public Integer getKcId() {
		return kcId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column kc_tx_rel.kc_id
	 * @param kcId  the value for kc_tx_rel.kc_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	public void setKcId(Integer kcId) {
		this.kcId = kcId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column kc_tx_rel.tx_id
	 * @return  the value of kc_tx_rel.tx_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	public Integer getTxId() {
		return txId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column kc_tx_rel.tx_id
	 * @param txId  the value for kc_tx_rel.tx_id
	 * @mbggenerated  Wed Feb 22 15:29:16 CST 2017
	 */
	public void setTxId(Integer txId) {
		this.txId = txId;
	}
}