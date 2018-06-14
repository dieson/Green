package com.dieson.service.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dieson.service.InitHttpConnect;

/**
 * @author Dieson Zuo
 * @date Nov 16, 2016 5:24:14 PM
 */
@Service("initHttpConnectService")
public class InitHttpConnectImp implements InitHttpConnect {

	/**
	 * The HttpURLConnection to connect the website.
	 */
	public HttpURLConnection hc = null;
	/**
	 * String Base url
	 */
	private static final String baseurl = "https://portal.hiar.io/account/signin/";
	/**
	 * String loginData 默认登录账号密码
	 */
	private static final String loginData = "account=86341949%40qq.com&password=zuoran335";
	/**
	 * sendCoding String 发送请求的编码方式
	 */
	private static final String sendCoding = "UTF-8";
	/**
	 * Parsecode String 本地解析时的编码方式
	 */
	private static final String Parsecode = "UTF-8";

	@Override
	public void initCon(String str) throws Exception {

		URL url = null;
		if (str != null && !str.equals("")) {
			url = new URL(str);
		} else {
			url = new URL(InitHttpConnectImp.baseurl);
		}

		HttpURLConnection.setFollowRedirects(true);
		hc = (HttpURLConnection) url.openConnection();
		hc.setDoOutput(true);
		hc.setDoInput(true);
		hc.setRequestMethod("POST");
		hc.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
		hc.setDoOutput(true);
		hc.setRequestProperty("Content-Type", "application/json");
		hc.setRequestProperty("Content-Language", "zh-cn");
		hc.setRequestProperty("Connection", "keep-alive");
		hc.setRequestProperty("Cache-Control", "no-cache");
	}

	@Override
	public void sendPost(String postdata) throws Exception {

		OutputStream os = hc.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, InitHttpConnectImp.sendCoding);
		
		if (postdata != null && !postdata.equals("")) {
			osw.write(postdata);
		} else {
			osw.write(InitHttpConnectImp.loginData);
		}
		osw.flush();
		osw.close();
		os.close();
	}

	@Override
	public String readData() throws IOException {

		int code = hc.getResponseCode();
		StringBuffer sb = null;
		if (code == HttpURLConnection.HTTP_OK) {
			sb = new StringBuffer();
			InputStream is = hc.getInputStream();// 获取输入流
			InputStreamReader isr = new InputStreamReader(is, InitHttpConnectImp.Parsecode);// 包装流并且指定编码方式
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			do {
				line = br.readLine();// 读取内容
				if (line != null && !line.equals("")) {
					sb.append(line);
				}
			} while (line != null);
			// 关闭流
			br.close();
			isr.close();
			is.close();
			return sb.toString();
		} else
			return null;
	}

	@Override
	public String getCookie() {

		String cookieskey = "Set-Cookie";
		Map<String, List<String>> maps = hc.getHeaderFields();
		List<String> coolist = maps.get(cookieskey);
		Iterator<String> it = coolist.iterator();
		StringBuffer sbu = new StringBuffer();
		sbu.append("eos_style_cookie=default; ");
		while (it.hasNext()) {
			sbu.append(it.next() + " ");
		}
		return sbu.toString();
	}

	@Override
	public String cookie(String data) {

		String res = null;
		try {

			this.initCon("");
			this.sendPost(data);
			res = this.getCookie();
			res = res.trim();
			this.killconnet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void killconnet() {

		hc.disconnect();
	}
	
	@Override
	public String getResult(String url, String postdata) {
		
		String responseStr = null;
		try {
			// HttpConnect初始化
			this.initCon(url);
			
			this.sendPost(postdata);
			// 读取报文
			responseStr = this.readData();

			this.killconnet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseStr;
	}

}
