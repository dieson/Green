package com.dieson.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.common.Const;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;

/**
 * @ClassName: IndexController
 * @Description:
 * @author: Dieson Zuo
 * @date: 2018年7月2日 上午10:09:06
 */
@Controller
public class IndexController {
	
	@Autowired
	private IUserService iUserService;

	/**
	 * 跳转到index.jsp页面，返回登录的用户名
	 */
	@RequestMapping(value = "/index.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index(HttpServletRequest request) {
		
		Integer userId = (Integer) request.getAttribute(Const.CURRENT_USER_ID);
		User user = iUserService.getUserInfoById(userId).getData();
		
		ModelAndView mv = new ModelAndView("home/index");
		mv.addObject("username", user.getUsername());
		return mv;
		
	}
}
