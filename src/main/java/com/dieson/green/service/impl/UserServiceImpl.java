package com.dieson.green.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.common.Const;
import com.dieson.green.common.ServerResponse;
import com.dieson.green.common.TokenCache;
import com.dieson.green.dao.UserMapper;
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
		// 默认把用户设置成为一个普通用户
		user.setRole(Const.Role.ROLE_CUSTOMER);
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
	public ServerResponse<String> forgetResetPasswor(String username, String passwordNew, String forgetToken) {
		if (StringUtils.isBlank(forgetToken)) {
			return ServerResponse.createByErrorMesssage("参数错误,token需要传递");
		}
		// 需要校验username, 因为token的key用到username去拼接,username为空会直接获得forgetToken
		ServerResponse<String> vaildResponse = this.checkVaild(username);
		if (vaildResponse.isSuccess()) {
			return ServerResponse.createByErrorMesssage("用户不存在");
		}
		String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);

		// 对cache中的token进行验证
		if (StringUtils.isBlank(token)) {
			return ServerResponse.createByErrorMesssage("token无效或者过期");
		}

		// str 是null也没有关系,不会报空指针
		if (StringUtils.equals(forgetToken, token)) {
			String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
			int resultCount = userMapper.updatePasswordByUsername(username, md5Password);

			if (resultCount > 0) {
				return ServerResponse.createBySuccessMessage("修改密码成功");
			}
		} else {
			return ServerResponse.createByErrorMesssage("token错误,请重新获取重置密码的token");
		}

		return ServerResponse.createByErrorMesssage("修改密码失败");
	}

	@Override
	public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
		// 防止横向越权,要校验一下这个用户的旧密码,一定要指定是这个用户,因为我们会count(1),如果不指定id,结果为true,count>0
		int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("旧密码错误");
		}

		user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
		int updateCount = userMapper.updateByPrimaryKeySelective(user);
		if (updateCount > 0) {
			return ServerResponse.createBySuccessMessage("密码更新成功");
		}

		return ServerResponse.createByErrorMesssage("密码更新失败");
	}

	@Override
	public ServerResponse<Integer> checkAdminRole(User user) {
		if (user != null && user.getRole().intValue() == Const.Role.ROLE_ADMIN) {
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

}
