package com.dieson.green.entiy;

import java.util.List;

import com.dieson.green.pojo.Projects;
import com.dieson.green.pojo.User;

/**
 * @ClassName: UserCustom
 * @Description: 用户的拓展类型
 * @author: Dieson Zuo
 * @date: 2018年7月23日 下午2:31:34
 */
public class UserCustom extends User {

	/**
	 * 用户所关联的项目信息
	 */
	private List<Projects> projects;

	/**
	 * @return the projects
	 */
	public List<Projects> getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
}
