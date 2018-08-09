package com.dieson.green.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.dto.Page;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.TestEnvironmentCustom;
import com.dieson.green.pojo.TestEnvironment;
import com.dieson.green.service.ITestEnvironmentService;

/**
 * @ClassName: TestEnvironmentController
 * @Description: 测试环境
 * @author: Dieson Zuo
 * @date: 2018年7月18日 下午2:08:07
 */
@Controller
@RequestMapping("/environment/")
public class TestEnvironmentController {

	@Autowired
	ITestEnvironmentService iTestEnvironmentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<List<TestEnvironmentCustom>> load1(@RequestBody Page<?> page) throws Exception {
		
		ServerResponse<List<TestEnvironmentCustom>> environments = iTestEnvironmentService.getTestEnvironment();
		return null;

	}

	/**
	 * 打开测试环境管理页面
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "environment_index.do", method = RequestMethod.GET)
	public ModelAndView load() throws Exception {

		ServerResponse<List<TestEnvironmentCustom>> list = iTestEnvironmentService.getTestEnvironment();
		List<TestEnvironmentCustom> environments = list.getData();

		ModelAndView mv = new ModelAndView("environment/environmentMain");
		mv.addObject("environments", environments);

		return mv;
	}

	/**
	 * 创建测试环境
	 *
	 * @param projects
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> create(@RequestBody TestEnvironment environment) throws Exception {

		return iTestEnvironmentService.createTestEnvironment(environment);
	}

	/**
	 * 更新项目名称
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ServerResponse<String> update(TestEnvironment environment) {

		return iTestEnvironmentService.updateTestEnvironment(environment);
	}

	/**
	 * 删除项目
	 */
	@RequestMapping(value = "deleteEnvironment.do", method = RequestMethod.POST)
	public ServerResponse<String> deleteProject(@Param("environment_id") Integer environmentId) {

		return iTestEnvironmentService.deleteTestEnvironment(environmentId);
	}
}
