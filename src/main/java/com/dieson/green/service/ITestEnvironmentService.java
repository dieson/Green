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
	ServerResponse<List<TestEnvironmentCustom>> getTestEnvironment() throws Exception;

	/**
	 * 创建环境信息
	 * 
	 * @throws Exception
	 */
	ServerResponse<String> createTestEnvironment(TestEnvironment environment) throws Exception;

	/**
	 * 检验环境是否存在
	 * 
	 * @throws Exception
	 */
	ServerResponse<String> checkTestEnvironment(String url) throws Exception;

	/**
	 * 更新环境信息
	 */
	ServerResponse<String> updateTestEnvironment(TestEnvironment environment);

	/**
	 * 删除环境信息
	 */
	ServerResponse<String> deleteTestEnvironment(Integer id);

	/**
	 * 获取测试环境信息
	 */
	ServerResponse<List<TestEnvironmentCustom>> getTestEnvironmentPage(int totalPage, int limitPage) throws Exception;
}
