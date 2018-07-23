package com.dieson.green.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.common.Const;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;
import com.dieson.green.utils.PropertiesUtil;

/**
 * @ClassName: LoginHandlerIntercepter
 * @Description: 登录拦截器
 * @author: Dieson Zuo
 * @date: 2018年6月20日 上午10:25:13
 */
@Component
public class LoginHandlerIntercepter implements HandlerInterceptor {

	@Autowired
	private IUserService iUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		// 得到请求的url
		String url = request.getRequestURI();
		// 从配置中取逆名访问url,判断是否是公开 地址
		List<String> open_urls = (List<String>) (List) PropertiesUtil.getPropertyList("public.url");
		for (String open_url : open_urls) {
			if (url.indexOf(open_url) >= 0) {
				return true;
			}
		}

		//获取session登录信息
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		
		if(user != null) {
			ServerResponse<User> model = iUserService.getUserInfoById(user.getId());
			if (model.getCode() == 200) {
				request.setAttribute(Const.CURRENT_USER_ID, model.getData().getId());
				return true;
			}
		}
		response.sendRedirect("/green");
		return false;
		
		// 从request中得到token
		/*String token = (String) request.getHeader(Const.TOKEN);
		// 验证token
		Token model = iTokenManager.getToken(token);
		if (iTokenManager.checkToken(model)) {
			// 如果token验证成功，将token对应的用户id存在request中，便于之后注入
			request.setAttribute(Const.CURRENT_USER_ID, model.getUserId());
			return true;
		} else {
			response.sendRedirect("/green");
			return false;
		}*/

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
