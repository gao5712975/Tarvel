package com.tarvel.shiro.account;

import com.tarvel.shiro.service.ShiroService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;

/**
 * 初始化角色权限
 * @author liujiegang
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Section> {

    @Resource
    private ShiroService shiroService;
	private String filterChainDefinitions;
	
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	public Section getObject() throws Exception {
		Ini ini = new Ini();
		ini.load(filterChainDefinitions);
		Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
//		shiroService.setRolePurview(section);
		return section;
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}

}
