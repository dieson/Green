package com.dieson.service;

import java.util.Map;
import java.util.Vector;

/**
 * @author Dieson Zuo
 * @date Nov 17, 2016 10:33:50 AM
 */
public interface RequestHttp {

	/**
	 * 获取请求数据
	 * @param xmlName
	 * @return
	 */
	public Vector<String> getList(String xmlName);

	/**
	 * 获取请求数据
	 * @param xmlName
	 * @return
	 */
	public Map<String, String> getPostData(String xmlName);
}
