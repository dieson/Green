package com.dieson.green.service;

import java.util.List;

import com.dieson.green.dto.Page;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.TestEnvironmentCustom;
import com.dieson.green.pojo.TestEnvironment;

/**
 * @ClassName: ITestEnvironmentService
 * @Description: 测试环境
 * @author: Dieson Zuo
 * @date: 2018年7月18日 下午2:10:04
 */
public interface ITestEnvironmentService {

	/**
	 * 获取所有测试环境数据
	 * 
	 * @throws Exception
	 */
	List<TestEnvironmentCustom> getTestEnvironment() throws Exception;

	/**
	 * 创建环境信息
	 * 
	 * @throws Exception
	 */
	int createTestEnvironment(TestEnvironment environment) throws Exception;

	/**
	 * 检验环境是否存在
	 * 
	 * @throws Exception
	 */
	int checkTestEnvironment(String url) throws Exception;

	/**
	 * 更新环境信息
	 */
	int updateTestEnvironment(TestEnvironment environment);

	/**
	 * 删除环境信息
	 */
	int deleteTestEnvironment(String name);

	/**
	 * 获取测试环境信息
	 */
	List<TestEnvironmentCustom> getTestEnvironmentPage(int totalPage, int limitPage) throws Exception;

	/**
	 * 根据环境名称获取测试环境url
	 */
	String getTestEnviromentByName(String name) throws Exception;
}
