package com.dieson.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dieson.green.pojo.User;

/**
 * @author Dieson Zuo
 * @date 创建时间：30 Nov 2016 1:50:42 pm
 */
public class TestClass {

	public static void main(String[] args) throws Exception {

		Map<String, String> c = new HashMap<>();

		List<String> li = new ArrayList<>();
		li.add("a");
		li.add("a");
		li.add("b");

		Set<String> se = new HashSet<>(li);
		System.out.println(se);

		TestClass tc = new TestClass();
		tc.readFile("C:\\Users\\Dieso\\Desktop\\120.200.txt");
		tc.comparator();
	}

	public void listToArray() {
		List<String> a = new ArrayList<String>();
		a.add("test");
		a.add("1");

		String[] b = a.toArray(new String[a.size()]);
		Arrays.sort(b);

		a = Arrays.asList(b);
		System.out.println(a);
	}

	public void comparator() {
		LinkedHashMap<String, User> m = new LinkedHashMap<>();
		User a = new User();
		a.setId(1);
		User b = new User();
		b.setId(2);

		m.put("b", b);
		m.put("a", a);
		System.out.println(m);

		List<Entry<String, User>> list = new ArrayList<Entry<String, User>>(m.entrySet());
		Collections.sort(list, new Comparator<Entry<String, User>>() {
			@Override
			public int compare(Entry<String, User> o1, Entry<String, User> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getId().compareTo(o2.getValue().getId());
			}
		});

		LinkedHashMap<String, User> lm = new LinkedHashMap<>();
		for (Entry<String, User> entry : list) {
			lm.put(entry.getKey(), entry.getValue());
		}
		System.out.println(lm.toString());

	}

	public void readFile(String filePath) throws Exception {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
		BufferedReader br = new BufferedReader(isr);

		Map<Character, Integer> m = new HashMap<>();
		String tmp = null;
		while ((tmp = br.readLine()) != null) {
			System.out.println(tmp);
			char[] c = tmp.toCharArray();
			for (Character b : c) {
				m.put(b, !m.containsKey(b) ? 1 : m.get(b) + 1);
			}
		}
		br.close();

		Set<Character> li = m.keySet();
		Character maxStr = null;
		Integer maxNO = 0;
		for (Character i : li) {
			if (m.get(i) > maxNO) {
				maxNO = m.get(i);
				maxStr = i;
			}
		}

		System.out.println("String:" + maxStr + "total:" + maxNO);
		
	}
}
