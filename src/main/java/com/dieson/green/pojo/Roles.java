package com.dieson.green.pojo;

public class Roles {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.id
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.name
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.demo
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    private Boolean demo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.permissions
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    private Integer permissions;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.id
     *
     * @return the value of roles.id
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.id
     *
     * @param id the value for roles.id
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.name
     *
     * @return the value of roles.name
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.name
     *
     * @param name the value for roles.name
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.demo
     *
     * @return the value of roles.demo
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public Boolean getDemo() {
        return demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.demo
     *
     * @param demo the value for roles.demo
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.permissions
     *
     * @return the value of roles.permissions
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public Integer getPermissions() {
        return permissions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.permissions
     *
     * @param permissions the value for roles.permissions
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}