package com.dieson.green.dao;

import com.dieson.green.pojo.Roles;

public interface RolesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insert(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insertSelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    Roles selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKeySelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKey(Roles record);
}