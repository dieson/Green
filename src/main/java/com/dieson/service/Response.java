package com.dieson.service;

import net.sf.json.JSONObject;

/**
 * @author Dieson Zuo
 * @date Nov 25, 2016 5:31:03 PM
 */
public interface Response {
	
	/**
	 * 获取报文格式
	 * @param responseStr
	 * @return
	 */
	public String getType(String responseStr);

	/**
	 * 解析报文
	 * @param classStr	类名
	 * @param responseStr	报文
	 * @return
	 */
	public Object startAnalysis(String classStr, String responseStr);

	/**
	 * 校验返回信息
	 * @param responseStr	报文
	 * @param expect	期望结果
	 * @return
	 */
	public boolean verifyResponse(String responseStr, String expect);

	/**
	 * 校验期望结果
	 * @param expect
	 * @param actual
	 * @return
	 */
	public boolean verify(JSONObject expect, JSONObject actual);
}
