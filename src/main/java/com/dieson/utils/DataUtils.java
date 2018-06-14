package com.dieson.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Dieson Zuo
 * @date Nov 4, 2016 5:07:53 PM
 */
public class DataUtils {

	public static JSONObject mapToJSON(Map<String, String> map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}

	public static JSONObject listToJSON(List<String> list) {
		JSONObject jsonObject = JSONObject.fromObject(list);
		return jsonObject;
	}

	public static JSONObject txtToMap(String filePath) {

		String str = DataUtils.readTxtFile(filePath);
		return DataUtils.strToJson(str);
	}

	public static JSONObject strToJson(String str) {

		JSONObject jsonObject = JSONObject.fromObject(str);
		return jsonObject;
	}

	public static JSONArray fileToJsonList(String path) {

		String jsonStr = DataUtils.readTxtFile(path);
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
		return jsonArray;
	}

	public static List<String> getXml(String path) throws Exception {

		List<String> data = new ArrayList();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		Element root = document.getRootElement();
		StringBuffer sb = null;

		Iterator it = root.elementIterator();
		while (it.hasNext()) {
			sb = new StringBuffer();
			Element element = (Element) it.next();

			// Iterator eleIt = element.elementIterator();
			// while (eleIt.hasNext()) {
			// Element e = (Element) eleIt.next();
			// sb.append(e.getName() + "=" + e.getText() + "&");
			// sb.append(e.getText());
			// }
			// String sbData = sb.toString();
			// sbData = sbData.substring(0, sbData.lastIndexOf("&"));
			data.add(element.getText().trim());
		}
		return data;
	}

	public static Map<String, String> getXmlData(String path) throws Exception {

		Map<String, String> data = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		Element root = document.getRootElement();

		Iterator it = root.elementIterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			data.put(element.getName(), element.getText());
		}
		return data;
	}

	public static String getStringValue(String String, String key) {

		JSONObject jsonObject = JSONObject.fromObject(String);
		return jsonObject.getString(key);
	}

	public static String readTxtFile(String filePath) {

		StringBuffer sb = null;
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				sb = new StringBuffer();
				InputStream is = new FileInputStream(file);// 获取输入流
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");// 包装流并且指定编码方式
				BufferedReader br = new BufferedReader(isr);

				String line = null;
				do {
					line = br.readLine();// 读取内容

					if (line != null && !line.equals("")) {
						line = line.trim();
						line = line.replaceAll("&nbsp;", "");
						sb.append(line);
					}
				} while (line != null);
				// 关闭流
				br.close();
				isr.close();
				is.close();

			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return sb.toString();
	}

}
