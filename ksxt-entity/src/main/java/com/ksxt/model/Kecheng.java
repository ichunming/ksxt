package com.ksxt.model;

import java.util.Date;

public class Kecheng {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.title
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.order_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kecheng.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.id
     *
     * @return the value of kecheng.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.id
     *
     * @param id the value for kecheng.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.title
     *
     * @return the value of kecheng.title
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.title
     *
     * @param title the value for kecheng.title
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.order_id
     *
     * @return the value of kecheng.order_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.order_id
     *
     * @param orderId the value for kecheng.order_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.status
     *
     * @return the value of kecheng.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.status
     *
     * @param status the value for kecheng.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.create_date
     *
     * @return the value of kecheng.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.create_date
     *
     * @param createDate the value for kecheng.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kecheng.update_date
     *
     * @return the value of kecheng.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kecheng.update_date
     *
     * @param updateDate the value for kecheng.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}