package com.dieson.green.mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dieson.green.dao.ModelsMapperCustom;
import com.dieson.green.dao.UserMapperCustom;
import com.dieson.green.entiy.ModelsCustom;
import com.dieson.green.entiy.UserCustom;

/**
 * @ClassName: ModelsMapperCustomTest
 * @Description:
 * @author: Dieson Zuo
 * @date: 2018年7月19日 上午11:14:25
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml","classpath*:applicationContext.xml", "classpath*:spring.xml", "classpath*:redis-context.xml"})    
public class ModelsMapperCustomTest {
	
	@Autowired
	ModelsMapperCustom modelsMapperCustom;
	
	@Autowired
	UserMapperCustom userMapperCustom;
	
	/**
	 * Test method for
	 * {@link com.dieson.green.dao.ModelsMapperCustom#findModelsProject()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindModelsProject() throws Exception {
		
		
		List<ModelsCustom> list = modelsMapperCustom.selectModelsProject();
		
		System.out.println(list);
		
	}
	
	@Test
	public void testSelectUserProject() throws Exception{
		List<UserCustom> list = userMapperCustom.selectUserProjects();
		
		System.out.println(list);
	}

}
