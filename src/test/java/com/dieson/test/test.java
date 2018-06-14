package com.dieson.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dieson.service.InitHttpConnect;
import com.dieson.service.imp.InitHttpConnectImp;
import com.dieson.utils.DataUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Dieson Zuo
 * @date 创建时间：30 Nov 2016 1:50:42 pm
 */
public class test {

	public static void main(String[] args) throws Exception {
		InitHttpConnect ihc = new InitHttpConnectImp();
		URL resourceData = ihc.getClass().getClassLoader().getResource("com/dieson/data/Login.json");
		String pathData = resourceData.getPath();
		JSONArray waiting = DataUtils.fileToJsonList(pathData);
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < waiting.size(); i++) {
			Map<String, String> map = new HashMap<>();
			JSONObject running = waiting.getJSONObject(i);
			
			// DeviceId
			String verifyDevice = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DlFileDetailsV2", running.getString("VerifyDeviceId"));
			System.out.println(verifyDevice);
			map.put("actualStr", verifyDevice);
			map.put("postData", running.getString("VerifyDeviceId"));
			map.put("url", running.getString("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DlFileDetailsV2"));
			
			// IsAccount
			String isAccount = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/AuthenticationService.svc/Islive", running.getString("IsAccount"));
		//	System.out.println(isAccount);
			map.put("isAccount", isAccount);
			
			// Dictionary
			String dictionary = ihc.getResult("http://192.168.1.101/FileServer/dictionaryAU.sqlite", "");
		//	System.out.println(dictionary);
			map.put("dictionary", dictionary);
			
			// DictionaryVersion
			String dictionaryV = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DictionaryVersion", "");
		//	System.out.println(dictionaryV);
			map.put("dictionaryV", dictionaryV);
			
			// AuthenticationService
			String authentication = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/AuthenticationService.svc/Islive", "");
		//	System.out.println(authentication);
			map.put("authentication", authentication);
			list.add(map);
		}
		
	}

}
