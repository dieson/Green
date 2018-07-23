package com.dieson.green.service;

import java.util.List;

import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.ModelsCustom;
import com.dieson.green.pojo.Models;

/**
 * @ClassName: IModel
 * @Description: 模块
 * @author: Dieson Zuo
 * @date: 2018年7月18日 下午3:48:55
 */
public interface IModelService {

	/**
	 * 获取所有模块信息
	 */
	ServerResponse<List<ModelsCustom>> getModelsCustom() throws Exception;
	
	/**
	 * 创建模块
	 */
	ServerResponse<String> createModels(Models models) throws Exception;
	
	/**
	 * 检验模块名称是否存在
	 */
	ServerResponse<String> checkModelName(String modelName) throws Exception;
	
	/**
	 * 更新模块信息
	 */
	ServerResponse<String> updateModel(Models models) throws Exception;
	
	/**
	 * 删除模块
	 */
	ServerResponse<String> deleteModel(Integer id) throws Exception;
}
