package com.ksxt.model;

import java.util.Date;

public class Tixing {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tixing.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tixing.type
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tixing.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tixing.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tixing.id
     *
     * @return the value of tixing.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tixing.id
     *
     * @param id the value for tixing.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tixing.type
     *
     * @return the value of tixing.type
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tixing.type
     *
     * @param type the value for tixing.type
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tixing.create_date
     *
     * @return the value of tixing.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tixing.create_date
     *
     * @param createDate the value for tixing.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tixing.update_date
     *
     * @return the value of tixing.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tixing.update_date
     *
     * @param updateDate the value for tixing.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}