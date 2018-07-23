package com.dieson.green.service;

import java.util.List;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.Projects;

/**
 * @ClassName: IProjectService
 * @Description: 
 * @author: Dieson Zuo
 * @date: 2018年7月18日 上午11:17:10
 */
public interface IProjectService {
	
	/**
	 * 获取所有项目数据
	 */
	ServerResponse<List<Projects>> getProject();
	
	/**
	 *	创建项目	
	 */
	ServerResponse<String> createProject(Projects projects);
	
	/**
	 * 检验项目名称是否存在
	 */
	ServerResponse<String> checkProjectName(String projectName);
	
	/**
	 * 更新项目信息
	 */
	ServerResponse<String> updateProject(Projects projects);
	
	/**
	 * 删除项目
	 */
	ServerResponse<String> deleteProject(Integer id);
}
