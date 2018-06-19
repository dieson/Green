package com.dieson.green.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieson.green.common.Const;
import com.dieson.green.common.ServerResponse;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 用户登录
	 *
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(String username, String password, HttpSession session) {
		ServerResponse<User> response = iUserService.login(username, password);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();
	}

	/**
	 * 用户注册
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> register(User user) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		ParsePosition pos = new ParsePosition(0);
//		Date strtodate = formatter.parse("2016-11-06 16:56:45", pos);
//		user.setCreateTime(strtodate);
//		user.setUpdateTime(strtodate);

		return iUserService.register(user);
	}

	/**
	 * 用户填写input表单要实时验证用户名或者邮箱是否存在
	 *
	 * @param str
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> checkValid(String str) {

		return iUserService.checkVaild(str);
	}

	/**
	 * 获取当前用户信息
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> getUserInfo(HttpSession session) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user != null) {
			return ServerResponse.createBySuccess(user);
		}
		return ServerResponse.createByErrorMesssage("用户未登录,无法获取当前用户信息");
	}

	/**
	 * 登录状态下的重置密码
	 * 
	 * @param session
	 * @param passwordOld
	 * @param passwordNew
	 * @return
	 */
	@RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorMesssage("用户未登录");
		}

		return iUserService.resetPassword(passwordOld, passwordNew, user);
	}

}
