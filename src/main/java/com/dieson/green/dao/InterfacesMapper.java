package com.dieson.green.dao;

import com.dieson.green.pojo.Interfaces;

public interface InterfacesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insert(Interfaces record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insertSelective(Interfaces record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    Interfaces selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKeySelective(Interfaces record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interfaces
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKey(Interfaces record);
}