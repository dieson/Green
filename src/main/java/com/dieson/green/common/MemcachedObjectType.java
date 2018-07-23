package com.dieson.green.common;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 */
public enum MemcachedObjectType {

	LOGIN_TOKEN("_loginToken_:", 12*60*60 * 1), // 60分钟
	
	COMPANY("_companyInfo_:",60 * 60 * 1*10),//10个小时
	
	REGIST_CODE("_regist_code_:",15 * 60 * 1), // 15分钟
	
	PASSWORD_WRONG("_password_wrong_",10 * 60 * 1),//10分钟
	
	REGIST_TOKEN("_regist_token_",10*60),
	
	REGIST_SMS_CODE_IP("_regist_sms_code_ip_",24*60*60*1),
	
	BIND_PHONE_SMS_CODE_PHONE("_bind_phone_sms_code_phone_",24*60*60*1),
	
	BIND_PHONE_SMS_CODE("_bind_phone_sms_code_",10*60),
	
	REGIST_SMS_CODE("_regist_sms_code_phone_",10*60),
	
	FIND_PASS_SMS_TIME("_find_pass_send_sms_",2*60),
	
	FIND_PASS("_find_pass_",10*60),
	
	TODAY_WEATHER("_today_weather",1*60*60*1),
	
	SLEEP_TIME("_weather_data_limit",10*1000),
	
	SHARE_CODE_TIME("_share_code_time",24*60*60*30)

	;

	private String prefix;

	private int expiredTime;

	MemcachedObjectType(String prefix, int expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return "gameOptId:"+ ":" + prefix;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

}
