package com.dieson.green.dao;

import com.dieson.green.pojo.Parames;

public interface ParamesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insert(Parames record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int insertSelective(Parames record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    Parames selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKeySelective(Parames record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parames
     *
     * @mbg.generated Mon Jul 09 15:06:28 CST 2018
     */
    int updateByPrimaryKey(Parames record);
}