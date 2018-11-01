package com.dieson.green.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
    public ServerResponse<List<TestEnvironmentCustom>> getTestEnvironment() throws Exception {

        List<TestEnvironmentCustom> environment = testEnvironmentMapperCustom.selectEnvironmentUser();
        if (environment == null) {
            return ServerResponse.createByErrorMesssage("获取环境信息失败");
        }
        return ServerResponse.createBySuccess(environment);
    }

    @Override
    public ServerResponse<String> createTestEnvironment(TestEnvironment environment) throws Exception {

        ServerResponse<String> validResponse = this.checkTestEnvironment(environment.getUrl());
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        int resultCount = testEnvironmentMapper.insertSelective(environment);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMesssage("创建失败");
        }
        return ServerResponse.createBySuccessMessage("创建成功");
    }

    @Override
    public ServerResponse<String> checkTestEnvironment(String url) throws Exception {

        if (StringUtils.isNotBlank(url)) {
            // 开始校验
            int resultCount = testEnvironmentMapper.checkTestEnvironment(url);
            if (resultCount > 0) {
                return ServerResponse.createByErrorMesssage("环境已存在");
            } else {
                return ServerResponse.createBySuccessMessage("可创建环境");
            }
        } else {
            return ServerResponse.createByErrorMesssage("参数错误");
        }
    }

    @Override
    public ServerResponse<String> updateTestEnvironment(TestEnvironment environment) {

        int resultCount = testEnvironmentMapper.updateByPrimaryKeySelective(environment);
        if (resultCount == 1) {
            return ServerResponse.createByErrorMesssage("更新成功");
        }
        return ServerResponse.createByErrorMesssage("更新失败");
    }

    @Override
    public ServerResponse<String> deleteTestEnvironment(Integer id) {

        int resultCount = testEnvironmentMapper.deleteByPrimaryKey(id);
        if (resultCount != 0) {
            return ServerResponse.createByErrorMesssage("删除成功");
        }
        return ServerResponse.createByErrorMesssage("删除失败");
    }

    @Override
    public ServerResponse<List<TestEnvironmentCustom>> getTestEnvironmentPage(int totalPage, int limitPage)
            throws Exception {

        List<TestEnvironmentCustom> environment = testEnvironmentMapperCustom.selectEnvironmentUserPage(totalPage, limitPage);
        if (environment == null) {
            return ServerResponse.createByErrorMesssage("获取环境信息失败");
        }
        return ServerResponse.createBySuccess(environment);
    }

    @Override
    public ServerResponse<String> getTestEnviromentByName(String name) throws Exception {

        String url = testEnvironmentMapper.selectTestEnvironmentByName(name);
        if (url == null) {
            return ServerResponse.createByErrorMesssage("无法获取环境地址！");
        }
        return ServerResponse.createBySuccess(url);
    }


}
