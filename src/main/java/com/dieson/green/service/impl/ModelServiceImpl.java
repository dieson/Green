package com.dieson.green.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dieson.green.dao.ModelsMapper;
import com.dieson.green.dao.ModelsMapperCustom;
import com.dieson.green.dto.ServerResponse;
import com.dieson.green.entiy.ModelsCustom;
import com.dieson.green.pojo.Models;
import com.dieson.green.service.IModelService;

/**
 * @ClassName: ModelServiceImpl
 * @Description: 模块
 * @author: Dieson Zuo
 * @date: 2018年7月18日 下午3:49:23
 */
@Transactional
@Service("iModelService")
public class ModelServiceImpl implements IModelService {

	@Autowired
	ModelsMapperCustom modelsMapperCustom;

	@Autowired
	ModelsMapper modelsMapper;

	@Override
	public ServerResponse<List<ModelsCustom>> getModelsCustom() throws Exception {

		List<ModelsCustom> modelsCustom = modelsMapperCustom.selectModelsProject();
		if (modelsCustom == null) {
			return ServerResponse.createByErrorMesssage("获取模块列表失败");
		}
		return ServerResponse.createBySuccess(modelsCustom);
	}

	@Override
	public ServerResponse<String> createModels(Models models) throws Exception {

		ServerResponse<String> validResponse = this.checkModelName(models.getModelName());
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		int resultCount = modelsMapper.insertSelective(models);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMesssage("创建失败");
		}
		return ServerResponse.createBySuccessMessage("创建成功");
	}

	@Override
	public ServerResponse<String> checkModelName(String modelName) throws Exception {

		if (StringUtils.isNotBlank(modelName)) {
			// 开始校验
			int resultCount = modelsMapper.checkModelName(modelName);
			if (resultCount > 0) {
				return ServerResponse.createByErrorMesssage("模块已存在");
			} else {
				return ServerResponse.createBySuccessMessage("模块名称可使用");
			}
		} else {
			return ServerResponse.createByErrorMesssage("参数错误");
		}
	}

	@Override
	public ServerResponse<String> updateModel(Models models) throws Exception {
		
		if(StringUtils.isNotBlank(models.getModelName())) {
			return ServerResponse.createByErrorMesssage("请输入模块名称");
		} 
		
		int resultCount = modelsMapper.updateByPrimaryKeySelective(models);
		if (resultCount == 1) {
			return ServerResponse.createByErrorMesssage("更新成功");
		}
		return ServerResponse.createByErrorMesssage("更新失败");
	}

	@Override
	public ServerResponse<String> deleteModel(Integer id) throws Exception {

		int resultCount = modelsMapper.deleteByPrimaryKey(id);
		if (resultCount != 0) {
			return ServerResponse.createByErrorMesssage("删除成功");
		}
		return ServerResponse.createByErrorMesssage("删除失败");
	}

}
