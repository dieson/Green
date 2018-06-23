package com.dieson.green.common;

import java.security.Key;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dieson.green.utils.PropertiesUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenCache {

	// 声明日志
	private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

	private static Key getKeyInstance() {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(PropertiesUtil.getProperty("sercet.key", ""));
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}

	public static String createTokenCache(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
	}

	public static Map<String, Object> verifyTokenCache(String jwt) {
		try {
			Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
			return jwtClaims;
		} catch (Exception e) {
			logger.error("json web token verify failed");
			return null;
		}
	}
}
