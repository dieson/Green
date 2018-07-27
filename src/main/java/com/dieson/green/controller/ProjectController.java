package com.dieson.green.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.Projects;
import com.dieson.green.service.IProjectService;

/**
 * @ClassName: ProjectController
 * @Description: 项目管理
 * @author: Dieson Zuo
 * @date: 2018年7月3日 上午11:48:59
 */
@Controller
@RequestMapping("/project/")
public class ProjectController {

	@Autowired
	IProjectService iProjectService;

	/**
	 * 打开项目管理页面
	 */
	@RequestMapping(value = "project_index.do", method = RequestMethod.GET)
	public ModelAndView load() {

		ServerResponse<List<Projects>> list = iProjectService.getProject();
		List<Projects> projects = list.getData();

		ModelAndView mv = new ModelAndView("redirect:/project/projectMain.jsp");
		mv.addObject("projects", projects);

		return mv;
	}

	/**
	 * 创建项目
	 *
	 * @param projects
	 * @return
	 */
	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> create(@RequestBody Projects projects) {

		return iProjectService.createProject(projects);
	}

	/**
	 * 更新项目名称
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ServerResponse<String> update(@Param("project_name") String projectName, @Param("project_id") Integer projectId) {

		Projects project = new Projects();
		project.setProjectName(projectName);
		project.setId(projectId);

		return iProjectService.updateProject(project);
	}
	
	/**
	 * 删除项目
	 */
	@RequestMapping(value = "deleteProject.do", method = RequestMethod.POST)
	public ServerResponse<String> deleteProject(@Param("project_id") Integer projectId){
		
		return iProjectService.deleteProject(projectId);
	}
}
