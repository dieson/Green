package com.dieson.green.service;

import java.util.List;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.UserCustom;
import com.dieson.green.pojo.User;

/**
 * @author Dieson Zuo
 * @date Jun 14, 2018 5:01:42 PM
 * @parameter
 */
public interface IUserService {
	ServerResponse<User> login(String username, String password);

	ServerResponse<String> register(User user);

	ServerResponse<String> checkVaild(String str);

	ServerResponse<String> changePassword(String username, String passwordNew);

	ServerResponse<String> resetPassword(String username);

	ServerResponse<User> getUserInfo(String username);

	ServerResponse<User> getUserInfoById(Integer id);

	ServerResponse<String> updateUser(User user);

	ServerResponse<String> setAdmin(String username);

	ServerResponse<String> updateUserStatus(String username);

	/**
	 * 查询所有用户与其对应的项目信息
	 */
	ServerResponse<List<UserCustom>> getUserProject() throws Exception;
}
