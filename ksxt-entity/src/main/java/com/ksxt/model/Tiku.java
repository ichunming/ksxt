package com.ksxt.model;

import java.util.Date;

public class Tiku {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.name
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.kc_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer kcId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.path
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiku.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.id
     *
     * @return the value of tiku.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.id
     *
     * @param id the value for tiku.id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.name
     *
     * @return the value of tiku.name
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.name
     *
     * @param name the value for tiku.name
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.kc_id
     *
     * @return the value of tiku.kc_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getKcId() {
        return kcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.kc_id
     *
     * @param kcId the value for tiku.kc_id
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setKcId(Integer kcId) {
        this.kcId = kcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.path
     *
     * @return the value of tiku.path
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.path
     *
     * @param path the value for tiku.path
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.status
     *
     * @return the value of tiku.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.status
     *
     * @param status the value for tiku.status
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.create_date
     *
     * @return the value of tiku.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.create_date
     *
     * @param createDate the value for tiku.create_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiku.update_date
     *
     * @return the value of tiku.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiku.update_date
     *
     * @param updateDate the value for tiku.update_date
     *
     * @mbggenerated Sun Feb 12 19:00:46 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}