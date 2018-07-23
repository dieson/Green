package com.dieson.green.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.common.Const;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 用户登录，校验用户信息是否正确
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(@RequestBody User user, HttpSession session) {

		ServerResponse<User> responseBody = iUserService.login(user.getUsername(), user.getPassword());
		session.setAttribute(Const.CURRENT_USER, responseBody.getData());
		
		// 生成token，保存用户登录状态
//		Token token = iTokenManager.createToken(responseBody.getData().getId());
//		response.setHeader(Const.TOKEN, responseBody.getData().getId() + "_" + token.getToken());
		return responseBody;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpSession session) {

//		Integer userID = (Integer) request.getAttribute(Const.CURRENT_USER_ID);
//		iTokenManager.deleteToken(userID);
		
		session.removeAttribute(Const.CURRENT_USER);
		return new ModelAndView("redirect:/index.jsp");
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
	 * 修改密码
	 * 
	 * @param session
	 * @param passwordOld
	 * @param passwordNew
	 * @return
	 */
	@RequestMapping(value = "change_password.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> changePassword(String passwordOld, String passwordNew) {

		return iUserService.changePassword(passwordOld, passwordNew);
	}

}
