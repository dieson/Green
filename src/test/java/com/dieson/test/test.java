package com.dieson.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dieson Zuo
 * @date 创建时间：30 Nov 2016 1:50:42 pm
 */
public class test {
	
	public static <T> void printArray(T[] inputArray) {
		
	}

	public static void main(String[] args) throws Exception {
		TestExtend test = new TestExtend();
		test.test();
		
		Map<Character, Integer> map = new HashMap<>();
		System.out.println(map.get("a"));
	}

}
