package com.dieson.green.dao;

import java.util.List;

import com.dieson.green.entiy.ModelsCustom;

public interface ModelsMapperCustom {
	
	/**
	 * 查询模块关联的项目
	 */
	List<ModelsCustom> selectModelsProject() throws Exception;
}