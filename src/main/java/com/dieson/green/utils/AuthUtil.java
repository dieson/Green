package com.dieson.green.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dieson.green.common.TokenCache;

/**
 * @ClassName: AuthUtil
 * @Description:
 * @author: Dieson Zuo
 * @date: 2018年6月20日 下午5:45:07
 */
public class AuthUtil {
	// 声明日志
	private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

	private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
		Map<String, Object> r = new HashMap<>();
		String sessionId = request.getHeader("sessionId");
		if (sessionId != null) {
			r = decodeSession(sessionId);
			return r;
		}
		throw new Exception("session解析错误");
	}

	public static Long getUserId(HttpServletRequest request) throws Exception {
		return Long.valueOf((Integer) getClientLoginInfo(request).get("userId"));
	}

	public static Map<String, Object> decodeSession(String sessionId) {
		try {
			return TokenCache.verifyTokenCache(sessionId);
		} catch (Exception e) {
			logger.error("");
			return null;
		}
	}
}
