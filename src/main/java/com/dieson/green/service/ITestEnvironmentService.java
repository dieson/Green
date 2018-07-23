package com.dieson.green.service;

import java.util.List;

import com.dieson.green.dto.ServerResponse;
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
	 */
	ServerResponse<List<TestEnvironment>> getTestEnvironment();
	
	/**
	 * 创建环境信息
	 */
	ServerResponse<String> createTestEnvironment(TestEnvironment environment);
	
	/**
	 * 检验环境是否存在
	 */
	ServerResponse<String> checkTestEnvironment(String url);
	
	/**
	 * 更新环境信息
	 */
	ServerResponse<String> updateTestEnvironment(TestEnvironment environment);
	
	/**
	 * 删除环境信息
	 */
	ServerResponse<String> deleteTestEnvironment(Integer id);
}
