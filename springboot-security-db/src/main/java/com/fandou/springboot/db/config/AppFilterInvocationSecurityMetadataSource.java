/**   
 * @Title: AppFilterInvocationSecurityMetadataSource.java 
 * @Package com.fandou.springboot.db.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午5:31:49
 * @version V0.0.1  
 */
package com.fandou.springboot.db.config;

import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.fandou.springboot.db.model.Menu;
import com.fandou.springboot.db.model.Role;
import com.fandou.springboot.db.service.MenuService;

/**
 * @Title: AppFilterInvocationSecurityMetadataSource
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午5:31:49
 * @version V0.0.1
 */
@Component
public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private Logger logger = LogManager.getLogger(AppFilterInvocationSecurityMetadataSource.class);
	
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * DEFAULT_CONFIG_ATTRIBUTE：缺省权限角色，实际权限大小，由AppAccessDecisionManager决定
	 */
	public final static String DEFAULT_CONFIG_ATTRIBUTE = "ROLE_DEFAULT";

	/** 
	 * @Title: getAttributes 
	 * @Description: 对当前请求的资源（URL）进行检查，从数据库中查询当前访问的请求（资源）所需的所有角色：即有哪些角色可以访问当前的请求（资源）
	 * @param filterInvocation FilterInvocation对象
	 * @return 返回访问当前资源所需的所有权限集合，即角色集合
	 * @throws IllegalArgumentException
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object filterInvocation) throws IllegalArgumentException {
		logger.info("调用了AppFilterInvocationSecurityMetadataSource  ===================>  getAttributes::filterInvocation");
		
		/*
		 * 当前请求的资源：即url
		 */
		String requestUrl = ((FilterInvocation)filterInvocation).getRequestUrl();
		logger.info("当前请求的URL => " + requestUrl);
		
		//TODO 从数据库中获取资源及其授权角色数据：实际开发中，可以将数据缓存在redis或其它缓存组件中供使用
		List<Menu> allMenus = menuService.getAllMenus();
		
		/*
		 * 如果系统对该URL配置了访问权限，即请求的URL属于被限制访问的资源，则返回可以访问该资源的角色列表（权限）
		 */
		StringBuffer rolesInfo = new StringBuffer();//for test
		for(Menu menu : allMenus) {
			if(antPathMatcher.match(menu.getPattern(), requestUrl)) {
				List<Role> roles = menu.getRoles();
				String[] roleArr = new String[roles.size()];
				for(int i = 0; i < roleArr.length; i++) {
					roleArr[i] = roles.get(i).getCode();
					
					//for test
					rolesInfo.append(roles.get(i).getCode());
					if(i < roleArr.length - 1) {
						rolesInfo.append(",");
					}
					
				}
				logger.info("当前请求的URL在系统中定义的资源ID/PATTERN为 => " + menu.getPattern());
				logger.info("可以访问该资源的角色一共有 => " + rolesInfo);
				return SecurityConfig.createList(roleArr);
			}
		}
		
		/*
		 *  如果系统未对该URL配置访问权限，则返回默认权限，接下来，将交由访问决策类AppAccessDecisionManager对默认权限进行响应
		 */
		logger.info("当前请求URL未配置访问限制，返回默认角色：" + DEFAULT_CONFIG_ATTRIBUTE);
		return SecurityConfig.createList(DEFAULT_CONFIG_ATTRIBUTE);
	}

	/** 
	 * @Title: getAllConfigAttributes 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		logger.info("调用了AppFilterInvocationSecurityMetadataSource  ===================>  getAllConfigAttributes");
		return null;
	}

	/** 
	 * @Title: supports 
	 * @Description: 一句话描述方法的作用
	 * @param clazz
	 * @return
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("调用了AppFilterInvocationSecurityMetadataSource  ===================>  supports::clazz");
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
