package com.dieson.green.entiy;

import com.dieson.green.pojo.Models;

/**
 * @ClassName: ModelsCustom
 * @Description: 模块的拓展类
 * @author: Dieson Zuo
 * @date: 2018年7月19日 上午11:00:25
 */
public class ModelsCustom extends Models{
	
	/**
	 * 项目名称
	 */
	private String projectName;

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
