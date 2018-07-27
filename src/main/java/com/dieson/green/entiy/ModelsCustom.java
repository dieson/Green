package com.dieson.green.entiy;

import com.dieson.green.pojo.Models;
import com.dieson.green.pojo.Projects;

/**
 * @ClassName: ModelsCustom
 * @Description: 模块的拓展类
 * @author: Dieson Zuo
 * @date: 2018年7月19日 上午11:00:25
 */
public class ModelsCustom extends Models {

	/**
	 * 模块所对应的项目
	 */
	private Projects project;

	/**
	 * @return the project
	 */
	public Projects getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Projects project) {
		this.project = project;
	}

}
