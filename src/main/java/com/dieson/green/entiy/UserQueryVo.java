package com.dieson.green.entiy;

import java.util.List;

import com.dieson.green.pojo.Projects;
import com.dieson.green.pojo.User;

/**
 * @ClassName: UserProject
 * @Description: 用户项目信息
 * @author: Dieson Zuo
 * @date: 2018年7月12日 下午4:30:42
 */
public class UserQueryVo {
	
	/**
	 * 用户信息
	 */
	private User user;
	
	/**
	 * 项目信息
	 */
	private List<Projects> project;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the projectCustom
	 */
	public List<Projects> getProject() {
		return project;
	}

	/**
	 * @param projectCustom
	 *            the projectCustom to set
	 */
	public void setProject(List<Projects> project) {
		this.project = project;
	}

}
