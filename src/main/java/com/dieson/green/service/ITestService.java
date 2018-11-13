package com.dieson.green.service;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.TestCase;

/**
 * @ClassName: ITestService
 * @Description:
 * @author: Dieson Zuo
 * @date: Created in 9:36 2018/11/9
 */
public interface ITestService {

    /**
     * 发送请求
     * @param url
     * @param testCase
     * @return
     * @throws Exception
     */
    String runTest(String url, TestCase testCase) throws Exception;

    String request(String url, TestCase testCase) throws Exception;
}
