package com.dieson.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dieson.green.entiy.TestEnvironmentCustom;

/**
 * @ClassName: TestEnvironmentMapperCustom
 * @Description: 测试环境拓展
 * @author: Dieson Zuo
 * @date: 2018年7月24日 下午4:03:01
 */
public interface TestEnvironmentMapperCustom {

	/**
	 * 查询环境信息和创建用户
	 */
	List<TestEnvironmentCustom> selectEnvironmentUser() throws Exception;

	/**
	 * 分页查询环境信息
	 */
	List<TestEnvironmentCustom> selectEnvironmentUserPage(@Param("totalPage") int totalPage, @Param("limitPage") int limitPage) throws Exception;
}
