package com.dieson.green.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.dao.ProjectsMapper;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.pojo.Projects;
import com.dieson.green.service.IProjectService;

/**
 * @ClassName: ProjectServiceImpl
 * @Description:
 * @author: Dieson Zuo
 * @date: 2018年7月18日 上午11:19:02
 */
@Transactional
@Service("iProjectService")
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectsMapper projectsMapper;

	@Override
	public ServerResponse<List<Projects>> getProject() {

		List<Projects> projects = projectsMapper.selecProjects();
		if (projects == null) {
			return ServerResponse.createByErrorMesssage("获取项目列表失败");
		}
		return ServerResponse.createBySuccess(projects);
	}

	@Override
	public ServerResponse<String> createProject(Projects projects) {

		ServerResponse<String> validResponse = this.checkProjectName(projects.getProjectName());
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		int resultCount = projectsMapper.insertSelective(projects);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("创建失败");
		}
		return ServerResponse.createBySuccessMessage("创建成功");
	}

	@Override
	public ServerResponse<String> checkProjectName(String projectName) {

		if (StringUtils.isNotBlank(projectName)) {
			// 开始校验
			int resultCount = projectsMapper.checkProjectName(projectName);
			if (resultCount > 0) {
				return ServerResponse.createByErrorMesssage("项目已存在");
			} else {
				return ServerResponse.createBySuccessMessage("项目名称可使用");
			}
		} else {
			return ServerResponse.createByErrorMesssage("参数错误");
		}
	}

	@Override
	public ServerResponse<String> updateProject(Projects projects) {

		if (StringUtils.isNotBlank(projects.getProjectName())) {
			return ServerResponse.createByErrorMesssage("请输入项目名称");
		}

		int resultCount = projectsMapper.updateByPrimaryKeySelective(projects);
		if (resultCount == 1) {
			return ServerResponse.createByErrorMesssage("更新成功");
		}
		return ServerResponse.createByErrorMesssage("更新失败");
	}

	@Override
	public ServerResponse<String> deleteProject(Integer id) {

		int resultCount = projectsMapper.deleteByPrimaryKey(id);
		if (resultCount != 0) {
			return ServerResponse.createByErrorMesssage("删除成功");
		}
		return ServerResponse.createByErrorMesssage("删除失败");
	}

}
