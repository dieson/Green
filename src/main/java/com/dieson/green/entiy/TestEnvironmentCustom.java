package com.dieson.green.entiy;

import com.dieson.green.pojo.TestEnvironment;
import com.dieson.green.pojo.User;

/**
 * @ClassName: TestEnvironmentMapperCustom
 * @Description: 测试环境拓展类型
 * @author: Dieson Zuo
 * @date: 2018年7月24日 下午4:00:30
 */
public class TestEnvironmentCustom extends TestEnvironment {

	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
