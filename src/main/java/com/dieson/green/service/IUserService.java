package com.dieson.green.service;

import com.dieson.green.pojo.User;

/** 
 * @author  Dieson Zuo 
 * @date Jun 14, 2018 5:01:42 PM 
 * @parameter  
 */
public interface IUserService {
	User login(String username, String password);
	
	String register(User user);
	
	String checkVaild(String str, String type);
	
	String forgetResetPasswor(String username, String passwordNew, String forgetToken);
	
	String resetPassword(String passwordOld, String passwordNew, User user);
	
}
