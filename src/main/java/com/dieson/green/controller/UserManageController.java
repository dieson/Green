package com.dieson.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieson.green.common.ServerResponse;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;

/**
 * @ClassName: UserManagerController
 * @Description: 用户管理
 * @author: Dieson Zuo
 * @date: 2018年6月20日 上午10:12:11
 */
@Controller
@RequestMapping("/user/manage/")
public class UserManageController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 创建用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> create(User user) {
		return iUserService.register(user);
	}

	/**
	 * 忘记密码中的重置密码
	 * 
	 * @param username
	 * @param passwordNew
	 * @return
	 */
	@RequestMapping(value = "change_password.do", method = RequestMethod.POST)
	public ServerResponse<String> changePasswor(String username, String passwordNew) {
		return iUserService.changePassword(username, passwordNew);
	}
}
