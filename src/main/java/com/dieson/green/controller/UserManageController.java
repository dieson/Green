package com.dieson.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.UserCustom;
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
	public ServerResponse<String> create(@RequestBody User user) {

		return iUserService.register(user);
	}

	/**
	 * 打开用户管理页面
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "user_index.do", method = RequestMethod.GET)
	public ModelAndView load() throws Exception {

		ServerResponse<List<UserCustom>> list = iUserService.getUserProject();
		List<UserCustom> uqv = list.getData();

		ModelAndView mv = new ModelAndView("user/userMain");
		mv.addObject("uqv", uqv);

		return mv;
	}

	/**
	 * 更新用户
	 */
	@RequestMapping(value = "changeUser.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> changeUser(@RequestBody User user) {

		return iUserService.updateUser(user);
	}

	/**
	 * 禁用用户
	 */
	@RequestMapping(value = "update_user_status.do", method = RequestMethod.POST)
	public ModelAndView updateUserStatus(String username) {

		iUserService.updateUserStatus(username);

		return new ModelAndView("redirect:/user/userMain.jsp");
	}

	/**
	 * 重置密码
	 * 
	 * @param username
	 * @param passwordNew
	 * @return
	 */
	@RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
	public ServerResponse<String> resetPasswor(String username) {

		return iUserService.resetPassword(username);
	}

	/**
	 * 更新管理员权限
	 */
	@RequestMapping(value = "set_admin.do", method = RequestMethod.POST)
	public ModelAndView setAdmin(String username) {

		iUserService.setAdmin(username);
		return new ModelAndView("redirect:/user/userMain.jsp");
	}
}
