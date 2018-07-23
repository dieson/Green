package com.dieson.green.common;

/**
 * 常量类
 */
public class Const {

	public static final String CURRENT_USER = "CurrentUser";

	/**
	 * 存储当前登录用户id的字段名
	 */
	public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
	
	public static final String RESET_PASSWORD = "Passw0rd";

	/**
	 * 存放token的header字段
	 */
	public static final String TOKEN = "csrftoken";

	public interface Role {
		int ROLE_CUSTOMER = 0; // 普通用户
		int ROLE_ADMIN = 1; // 管理员用户
	}
}
