package com.dieson.green.service;

import com.dieson.green.common.ServerResponse;
import com.dieson.green.pojo.User;

/** 
 * @author  Dieson Zuo 
 * @date Jun 14, 2018 5:01:42 PM 
 * @parameter  
 */
public interface IUserService {
	ServerResponse<User> login(String username, String password);
	
	ServerResponse<String> register(User user);	
	
	ServerResponse<String> checkVaild(String str);
	
	ServerResponse<String> forgetResetPasswor(String username, String passwordNew, String forgetToken);
	
	ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
	
	ServerResponse<Integer> checkAdminRole(User user);
	
}
