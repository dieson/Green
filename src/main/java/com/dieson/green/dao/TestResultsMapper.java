package com.dieson.green.dao;

import com.dieson.green.pojo.TestResults;

public interface TestResultsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    int insert(TestResults record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    int insertSelective(TestResults record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    TestResults selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    int updateByPrimaryKeySelective(TestResults record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_results
     *
     * @mbg.generated Fri Nov 02 15:28:10 CST 2018
     */
    int updateByPrimaryKey(TestResults record);
}