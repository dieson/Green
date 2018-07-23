package com.dieson.green.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dieson.green.common.MemcachedObjectType;
import com.dieson.green.pojo.Token;
import com.dieson.green.service.ITokenManager;

/**
 * @ClassName: TokenManager
 * @Description: 通过Redis存储和验证token的实现类
 * @author: Dieson Zuo
 * @date: 2018年6月27日 下午12:38:17
 */
@Component
@Service("iTokenManager")
public class TokenManager implements ITokenManager {

	
	private RedisTemplate<Integer, String> redis;
	
	@Autowired
	public void setRedis(RedisTemplate redis) {
		this.redis = redis;
		// 泛型设置成Long后必须更改对应的序列化方案
		redis.setKeySerializer(new JdkSerializationRedisSerializer());
	}

	@Override
	public Token createToken(Integer userId) {
		//使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
		Token model = new Token(userId, token);
		// 存储到redis并设置过期时间
		redis.boundValueOps(userId).set(token, MemcachedObjectType.LOGIN_TOKEN.getExpiredTime(), TimeUnit.HOURS);
		return model;
	}

	@Override
	public boolean checkToken(Token model) {
		if (model == null) {
			return false;
		}
		String token = redis.boundValueOps(model.getUserId()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redis.boundValueOps(model.getUserId()).expire(MemcachedObjectType.LOGIN_TOKEN.getExpiredTime(), TimeUnit.HOURS);
		return true;
	}

	@Override
	public Token getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		// 使用userId和源token简单拼接成的token，可以增加加密措施
		Integer userId = Integer.valueOf(param[0]);
		String token = param[1];
		return new Token(userId, token);
	}

	@Override
	public void deleteToken(Integer userId) {
		redis.delete(userId);
	}

}
