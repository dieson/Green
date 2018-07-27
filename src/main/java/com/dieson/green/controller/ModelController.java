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
import com.dieson.green.entiy.ModelsCustom;
import com.dieson.green.pojo.Models;
import com.dieson.green.service.impl.ModelServiceImpl;

/**
 * @ClassName: ModelContoller
 * @Description:模块管理
 * @author: Dieson Zuo
 * @date: 2018年7月23日 上午11:21:54
 */
@Controller
@RequestMapping("/model/")
public class ModelController {

	@Autowired
	ModelServiceImpl iModelService;

	/**
	 * 打开模块管理页面
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "model_index.do", method = RequestMethod.GET)
	public ModelAndView load() throws Exception {

		ServerResponse<List<ModelsCustom>> list = iModelService.getModelsCustom();
		List<ModelsCustom> modelsCustom = list.getData();

		ModelAndView mv = new ModelAndView("redirect:/model/modelMain.jsp");
		mv.addObject("modelsCustom", modelsCustom);

		return mv;
	}

	/**
	 * 创建模块
	 *
	 * @param models
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> create(@RequestBody Models models) throws Exception {

		return iModelService.createModels(models);
	}

	/**
	 * 更新模块名称
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ServerResponse<String> update(@RequestBody Models models) throws Exception {

		return iModelService.updateModel(models);
	}

	/**
	 * 删除模块
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public ServerResponse<String> deleteProject(@Param("model_id") Integer modelId) throws Exception {

		return iModelService.deleteModel(modelId);
	}
}
