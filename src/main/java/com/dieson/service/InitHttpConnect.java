package com.dieson.service;

import java.io.IOException;

/**
 * @author Dieson Zuo
 * @date Nov 16, 2016 5:22:06 PM
 */
public interface InitHttpConnect {

	/**
	 * 初始化request
	 * 
	 * @param str
	 *            请求地址
	 * @throws Exception
	 */
	public void initCon(String str) throws Exception;
	/**
	 * 发送request
	 * 
	 * @param postdata
	 *            String 要发送的数据
	 * @throws Exception
	 */
	public void sendPost(String postdata) throws Exception;
	/**
	 * 读取返回报文
	 * 
	 * @return String 读取的内容
	 */
	public String readData() throws IOException;
	/**
	 * 获取cookie
	 * 
	 * @return
	 */
	public String getCookie();
	/**
	 * 发送request，获取返回的cookie
	 * @param data	请求数据
	 * @return
	 */
	public String cookie(String data);
	/**
	 * 断开请求
	 */
	public void killconnet();
	/**
	 * 发送请求获取返回的报文
	 * @param url	请求地址
	 * @param postdata	请求参数
	 * @return
	 */
	String getResult(String url, String postdata);
}
