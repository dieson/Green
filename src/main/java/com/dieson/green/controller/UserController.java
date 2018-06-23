package com.dieson.green.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String test() {
		return "forward:home";
	}

	/**
	 * 用户登录
	 *
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		ServerResponse<User> response = iUserService.login(user.getUsername(), user.getPassword());
//		if (response.isSuccess()) {
//			session.setAttribute(Const.CURRENT_USER, response.getData());
//		}
		return response;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();
	}

	/**
	 * 用户填写input表单要实时验证用户名是否存在
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
	@RequestMapping(value = "get_user_info.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ServerResponse<User> getUserInfo(HttpSession session) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user != null) {
			return ServerResponse.createBySuccess(user);
		}
		return ServerResponse.createByErrorMesssage("用户未登录");
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

		return iUserService.resetPassword(passwordOld, passwordNew, user);
	}

}
