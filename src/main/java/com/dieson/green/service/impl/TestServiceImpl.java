package com.dieson.green.service.impl;

import com.dieson.green.common.Const;
import com.dieson.green.dao.TestCaseMapper;
import com.dieson.green.pojo.TestCase;
import com.dieson.green.service.ITestService;
import com.dieson.green.utils.AssertUtil;
import com.dieson.green.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("iTestService")
public class TestServiceImpl implements ITestService {

    @Autowired
    TestCaseMapper testCaseMapper;

    /**
     * 执行数据库测试用例
     *
     * @param url
     * @param testCase
     * @return
     */
    @Override
    public String runTest(String url, TestCase testCase) {
        String responseData = "";
        switch (testCase.getRequestType()) {
            case Const.GET:
                responseData = HttpClientUtil.get(url);
                break;
            case Const.POST:
                responseData = HttpClientUtil.post(url, testCase.getRequestData());
                break;
            case Const.PUT:
                break;
            case Const.DELETE:
                break;
        }
        return responseData;
    }

    /**
     * 执行单个测试用例
     *
     * @param url
     * @param testCase
     * @return
     */
    @Override
    public String request(String url, TestCase testCase) {
        String expect = testCase.getExpectData();
        String actual = HttpClientUtil.post(url, testCase.getRequestData());

        return AssertUtil.assertData(expect, actual);
    }
}
