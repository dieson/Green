package com.dieson.green.dao;

import java.util.List;

import com.dieson.green.entiy.UserCustom;

/**
 * @ClassName: UserMapperCustom
 * @Description: 用户拓展的dao
 * @author: Dieson Zuo
 * @date: 2018年7月23日 下午2:37:20
 */
public interface UserMapperCustom {

	/**
	 * 查询用户及所关联的项目信息
	 */
	List<UserCustom> selectUserProjects() throws Exception;

}
