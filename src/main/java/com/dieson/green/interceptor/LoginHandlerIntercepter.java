package com.dieson.green.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.common.Const;
import com.dieson.green.pojo.User;
import com.dieson.green.utils.PropertiesUtil;

/**
 * @ClassName: LoginHandlerIntercepter
 * @Description: 登录拦截器
 * @author: Dieson Zuo
 * @date: 2018年6月20日 上午10:25:13
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 得到请求的url
		String url = request.getRequestURI();
		// 判断是否是公开 地址
		// 实际开发中需要公开 地址配置在配置文件中
		// 从配置中取逆名访问url
		List<String> open_urls = (List<String>) (List) PropertiesUtil.getPropertyList("public.url");
		// 遍历公开 地址，如果是公开 地址则放行
		for (String open_url : open_urls) {
			if (url.indexOf(open_url) >= 0) {
				// 如果是公开 地址则放行
				return true;
			}
		}
		// 判断用户身份在session中是否存在
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		// 如果用户身份在session中存在放行
		if (user != null) {
			return true;
		}
		// 提示登录
		request.getRequestDispatcher("/user/get_user_info.do").forward(request, response);

		// 如果返回false表示拦截不继续执行handler，如果返回true表示放行
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
