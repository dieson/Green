package com.dieson.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dieson.service.InitHttpConnect;
import com.dieson.utils.DataUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Dieson Zuo
 * @date Dec 1, 2016 2:46:19 PM
 */
@Controller
public class LoginController {

	private InitHttpConnect ihc;

	public InitHttpConnect getIhc() {
		return ihc;
	}

	@Autowired
	public void setIhc(InitHttpConnect ihc) {
		this.ihc = ihc;
	}

	@RequestMapping(value = "/Login.do", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
		// 获取请求参数
		URL resourceData = this.getClass().getClassLoader().getResource("com/dieson/data/Login.json");
		String pathData = resourceData.getPath();
		JSONArray waiting = DataUtils.fileToJsonList(pathData);
		
		
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < waiting.size(); i++) {
			Map<String, String> map = new HashMap<>();
			JSONObject running = waiting.getJSONObject(i);
			
			// DeviceId
			String verifyDevice = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DlFileDetailsV2", running.getString("VerifyDeviceId"));
			map.put("actualStr", verifyDevice);
			map.put("postData", running.getString("VerifyDeviceId"));
			map.put("url", running.getString("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DlFileDetailsV2"));
			
			// IsAccount
			String isAccount = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/AuthenticationService.svc/Islive", running.getString("IsAccount"));
			map.put("isAccount", isAccount);
			
			// Dictionary
			String dictionary = ihc.getResult("http://192.168.1.101/FileServer/dictionaryAU.sqlite", "");
			map.put("dictionary", dictionary);
			
			// DictionaryVersion
			String dictionaryV = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/DeliveryService.svc/DictionaryVersion", "");
			map.put("dictionaryV", dictionaryV);
			
			// AuthenticationService
			String authentication = ihc.getResult("http://192.168.1.101/ln.red/service/ds.webservice/AuthenticationService.svc/Islive", "");
			map.put("authentication", authentication);
			list.add(map);
		}
		
		model.addAttribute("login", list);
		return "Login";
	}
}
