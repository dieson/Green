package com.dieson.green.utils;

import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by geely
 */
public class PropertiesUtil {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	private static Configuration props;

	static {
		String fileName = "green.properties";
		try {
			props = new PropertiesConfiguration(fileName);
		} catch (ConfigurationException e) {
			logger.error("配置文件读取异常", e);
		}
	}

	public static String getProperty(String key) {
		String value = props.getString(key.trim());
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return value.trim();
	}

	public static List<Object> getPropertyList(String key) {
		List<Object> value = props.getList(key);
		if (value == null || value.size() == 0) {
			return null;
		}
		return value;
	}

	public static String getProperty(String key, String defaultValue) {

		String value = props.getString(key.trim());
		if (StringUtils.isBlank(value)) {
			value = defaultValue;
		}
		return value.trim();
	}

}
