package com.dieson.test;

/**
 * @ClassName: TestExtend
 * @Description:
 * @author: Dieson Zuo
 * @date: 2018年7月30日 下午4:56:36
 */
public class TestExtend {

	int i = 1;

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i
	 *            the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}

	public void father() {
		System.out.println("father");
	}

	public void test() {
		System.out.println("father");
	}
}
