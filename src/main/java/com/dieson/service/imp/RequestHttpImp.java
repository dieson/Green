package com.dieson.service.imp;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.dieson.service.RequestHttp;
import com.dieson.utils.DataUtils;


/**
 * @author Dieson Zuo
 * @date Nov 17, 2016 10:53:04 AM
 */
@Service("requestHttpService")
public class RequestHttpImp implements RequestHttp {

	@Override
	public Vector<String> getList(String xmlName) {
		
		URL resource = this.getClass().getClassLoader().getResource("com/dieson/xml/" + xmlName);
		String path = resource.getPath();
		
		Vector<String> waiting = new Vector<String>();
		try {
			List<String> coll = DataUtils.getXml(path);
			waiting.addAll(coll);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return waiting;
	}

	@Override
	public Map<String, String> getPostData(String xmlName) {
		
		URL resource = this.getClass().getClassLoader().getResource("com/dieson/xml/" + xmlName);
		String path = resource.getPath();
		
		Map<String, String> waiting = new HashMap<>();
		try {
			waiting = DataUtils.getXmlData(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return waiting;
	}

}
