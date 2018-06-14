package com.dieson.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.dao.UserMapper;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;

/** 
 * @author  Dieson Zuo 
 * @date Jun 14, 2018 5:04:55 PM 
 * @parameter  
 */
@Transactional
@Service("iUserService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkVaild(String str, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgetResetPasswor(String username, String passwordNew, String forgetToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(String passwordOld, String passwordNew, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
