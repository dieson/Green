package com.dieson.green.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.common.Const;
import com.dieson.green.dao.UserMapper;
import com.dieson.green.dao.UserMapperCustom;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.UserCustom;
import com.dieson.green.pojo.User;
import com.dieson.green.service.IUserService;
import com.dieson.green.utils.MD5Util;

/**
 * @author Dieson Zuo
 * @date Jun 14, 2018 5:04:55 PM
 * @parameter
 */
@Transactional
@Service("iUserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapperCustom userMapperCustom;

	@Override
	public ServerResponse<User> login(String username, String password) {
		int resultCount = userMapper.checkUserName(username);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("用户名不存在");
		}

		String md5Password = MD5Util.MD5EncodeUtf8(password);
		User user = userMapper.selectLogin(username, md5Password);
		if (user == null) {
			return ServerResponse.createByErrorMesssage("密码错误");
		}

		user.setPassword(StringUtils.EMPTY);// 登录成功,把密码置位空
		return ServerResponse.createBySuccess("登录成功", user);
	}

	@Override
	public ServerResponse<String> register(User user) {
		ServerResponse<String> validResponse = this.checkVaild(user.getUsername());
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		// MD5加密
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

		int resultCount = userMapper.insert(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("注册失败");
		}
		return ServerResponse.createBySuccessMessage("注册成功");
	}

	@Override
	public ServerResponse<String> checkVaild(String str) {
		if (StringUtils.isNotBlank(str)) {
			// 开始校验
			int resultCount = userMapper.checkUserName(str);
			if (resultCount > 0) {
				return ServerResponse.createByErrorMesssage("用户名已存在");
			} else {
				return ServerResponse.createBySuccessMessage("用户名可使用");
			}
		} else {
			return ServerResponse.createByErrorMesssage("参数错误");
		}
	}

	@Override
	public ServerResponse<String> changePassword(String username, String passwordNew) {
		// 需要校验username,
		ServerResponse<String> vaildResponse = this.checkVaild(username);
		if (vaildResponse.isSuccess()) {
			return ServerResponse.createByErrorMesssage("用户不存在");
		}

		String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
		int resultCount = userMapper.updatePasswordByUsername(username, md5Password);

		if (resultCount > 0) {
			return ServerResponse.createBySuccessMessage("修改密码成功");
		}

		return ServerResponse.createByErrorMesssage("修改密码失败");
	}

	@Override
	public ServerResponse<String> resetPassword(String username) {

		User user = userMapper.selectUserByName(username);

		user.setPassword(MD5Util.MD5EncodeUtf8(Const.RESET_PASSWORD));
		int updateCount = userMapper.updateByPrimaryKeySelective(user);
		if (updateCount > 0) {
			return ServerResponse.createBySuccessMessage("密码更新成功");
		}

		return ServerResponse.createByErrorMesssage("密码更新失败");
	}

	@Override
	public ServerResponse<User> getUserInfo(String username) {
		int resultCount = userMapper.checkUserName(username);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("用户名不存在");
		}

		User user = userMapper.selectUserByName(username);

		return ServerResponse.createBySuccess(user);
	}

	@Override
	public ServerResponse<User> getUserInfoById(Integer id) {
		User user = userMapper.selectUserById(id);
		return ServerResponse.createBySuccess(user);
	}

	@Override
	public ServerResponse<String> updateUser(User user) {

		Integer userId = userMapper.selectUserByName(user.getUsername()).getId();
		user.setId(userId);

		int resultCount = userMapper.updateByPrimaryKeySelective(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("更新失败");
		}
		return ServerResponse.createByErrorMesssage("更新成功");
	}

	@Override
	public ServerResponse<String> setAdmin(String username) {

		User user = userMapper.selectUserByName(username);
		if (user.getIsSpre().equals(true)) {
			user.setIsSpre(false);
		} else {
			user.setIsSpre(true);
		}

		int resultCount = userMapper.updateByPrimaryKeySelective(user);
		if (resultCount == 1) {
			return ServerResponse.createByErrorMesssage("更新成功");
		}
		return ServerResponse.createByErrorMesssage("更新失败");
	}

	@Override
	public ServerResponse<String> updateUserStatus(String username) {

		User user = userMapper.selectUserByName(username);
		if (user.getStatus().equals(true)) {
			user.setStatus(false);
		} else {
			user.setStatus(true);
		}

		int resultCount = userMapper.updateByPrimaryKeySelective(user);
		if (resultCount == 1) {
			return ServerResponse.createByErrorMesssage("更新成功");
		}
		return ServerResponse.createByErrorMesssage("更新失败");
	}

	@Override
	public ServerResponse<List<UserCustom>> getUserProject() throws Exception {

		List<UserCustom> userCustom = userMapperCustom.selectUserProjects();

		return ServerResponse.createBySuccess(userCustom);
	}

}
