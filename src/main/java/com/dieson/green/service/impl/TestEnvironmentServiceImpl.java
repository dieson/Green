package com.dieson.green.service.impl;

import java.util.List;

import com.dieson.green.common.ResponseCode;
import com.dieson.green.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.dao.TestEnvironmentMapper;
import com.dieson.green.dao.TestEnvironmentMapperCustom;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.TestEnvironmentCustom;
import com.dieson.green.pojo.TestEnvironment;
import com.dieson.green.service.ITestEnvironmentService;

/**
 * @ClassName: TestEnvironmentServiceImpl
 * @Description: 测试环境接口实现
 * @author: Dieson Zuo
 * @date: 2018年7月18日 下午2:10:55
 */
@Transactional
@Service("iTestEnvironmentService")
public class TestEnvironmentServiceImpl implements ITestEnvironmentService {

    @Autowired
    TestEnvironmentMapper testEnvironmentMapper;

    @Autowired
    TestEnvironmentMapperCustom testEnvironmentMapperCustom;

    @Override
    public List<TestEnvironmentCustom> getTestEnvironment() throws Exception {

        return testEnvironmentMapperCustom.selectEnvironmentUser();
    }

    @Override
    public int createTestEnvironment(TestEnvironment environment) {
        return testEnvironmentMapper.insertSelective(environment);
    }

    @Override
    public int checkTestEnvironment(String url) throws Exception {

        return testEnvironmentMapper.checkTestEnvironment(url);
    }

    @Override
    public int updateTestEnvironment(TestEnvironment environment) {
        return testEnvironmentMapper.updateByPrimaryKeySelective(environment);

    }

    @Override
    public int deleteTestEnvironment(String name) {
        return testEnvironmentMapper.deleteByName(name);
    }

    @Override
    public List<TestEnvironmentCustom> getTestEnvironmentPage(int totalPage, int limitPage) throws Exception {

        return testEnvironmentMapperCustom.selectEnvironmentUserPage(totalPage, limitPage);

    }

    @Override
    public String getTestEnviromentByName(String name) throws Exception {

        return testEnvironmentMapper.selectTestEnvironmentByName(name);
    }


}
