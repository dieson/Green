package com.dieson.service;

import java.io.IOException;

/**
 * @author Dieson Zuo
 * @date Nov 16, 2016 6:09:50 PM
 */
public interface HttpConnect {
	/**
	 * POST请求初始化
	 * 
	 * String str 请求地址
	 */
	public void initPOST(String str) throws Exception;

	/**
	 * GET请求初始化
	 * 
	 * String str 请求地址
	 */
	public void initGET(String str, String param) throws Exception;

	/**
	 * 发送POST请求
	 * 
	 * @param postData
	 *            要发送的数据
	 * @throws Exception
	 */
	public void sendPost(String postData) throws Exception;

	/**
	 * 读取数据
	 * 
	 * @return String 读取的内容
	 */
	public String readData() throws IOException;

	/**
	 * 发送Post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param postdata
	 *            请求数据
	 * @param path
	 *            报文路径
	 * @return 
	 * @throws IOException
	 */
	public String getPostResult(String url, String postdata) throws IOException;
	
	/**
	 * 发送Get请求
	 * @param url
	 * @param getdata
	 * @return
	 * @throws IOException
	 */
	public String getGetResult(String url, String getdata) throws IOException;

	/**
	 * 断开HTTP连接
	 */
	public void killconnet();
}
