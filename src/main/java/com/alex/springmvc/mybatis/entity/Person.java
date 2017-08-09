package com.alex.springmvc.mybatis.entity;

/**
 * 通过MyBatis Generator自动生成
 * MyBatis的POJO类
 * 
 * @author xiaoming
 */
public class Person {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.id
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.name
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.dept
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    private String dept;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.website
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    private String website;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.phone
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    private String phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.id
     *
     * @return the value of person.id
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.id
     *
     * @param id the value for person.id
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.name
     *
     * @return the value of person.name
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.name
     *
     * @param name the value for person.name
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.dept
     *
     * @return the value of person.dept
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public String getDept() {
        return dept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.dept
     *
     * @param dept the value for person.dept
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.website
     *
     * @return the value of person.website
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public String getWebsite() {
        return website;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.website
     *
     * @param website the value for person.website
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.phone
     *
     * @return the value of person.phone
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.phone
     *
     * @param phone the value for person.phone
     *
     * @mbg.generated Tue Aug 08 21:39:42 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}