/**   
 * @Title: AppAccessDecisionManager.java 
 * @Package com.fandou.springboot.db.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:16:12
 * @version V0.0.1  
 */
package com.fandou.springboot.db.config;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * @Title: AppAccessDecisionManager
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:16:12
 * @version V0.0.1
 */
@Component
public class AppAccessDecisionManager implements AccessDecisionManager {
	private Logger logger = LogManager.getLogger(AppAccessDecisionManager.class);

	/**
	 * @Title: decide
	 * @Description: 检查当前登录用户是否具有当前请求URL（资源）的角色权限，如果没有则抛出异常
	 * @param authenticationUserWrapper : 当前登录的认证用户信息，即User类getAuthorities方法返回值
	 * @param filterInvocation          一个FilterInvocation对象，可以获取当前请求的资源信息（即URL）
	 * @param requiredRolesWrapper      ：访问当前请求URL所需的角色，即AppFilterInvocationSecurityMetadataSource类getAttributes方法的返回值
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 */
	@Override
	public void decide(Authentication authenticationUserWrapper, Object filterInvocation,
			Collection<ConfigAttribute> requiredRolesWrapper)
			throws AccessDeniedException, InsufficientAuthenticationException {
		logger.info("调用了AppAccessDecisionManager  ===================>  decide::authenticationUserWrapper,filterInvocation,requiredRolesWrapper");
		
		/*
		 * 当前登录用户的权限角色
		 */
		Collection<? extends GrantedAuthority> userRolesWrapper = authenticationUserWrapper.getAuthorities();

		/*
		 * 当前请求的资源
		 */
		String requestUrl = ((FilterInvocation) filterInvocation).getRequestUrl();
		logger.info("当前请求的URL => " + requestUrl);

		/*
		 * TODO 实际开发中， 1、可以默认未配置权限的资源开放访问、也可以设置黑名单（IP地址、用户名等）
		 * 2、配置了权限的资源，也可以设置用户白名单，例如测试账号 3、只对配置了权限的资源进行权限检查
		 */

		/*
		 * 遍历当前资源（即请求的URL）的所有角色（未配置权限的资源，系统会默认设置一个缺省的权限角色，
		 * 见AppFilterInvocationSecurityMetadataSource类的配置，所以这里至少会有一个角色AppFilterInvocationSecurityMetadataSource.DEFAULT_CONFIG_ATTRIBUTE），
		 * 将资源所需的角色与用户的所有角色进行比较，如匹配则正常返回，否则抛出异常
		 */
		for (ConfigAttribute requiredRoles : requiredRolesWrapper) {
			String requiredRole = requiredRoles.getAttribute();
			logger.info("当前请求URL[" + requestUrl + "] => 所需角色权限[" + requiredRole + "]");

			/*
			 * 响应未配置权限角色的资源（即缺省的权限角色的资源，见AppFilterInvocationSecurityMetadataSource类的配置）：
			 * 如果当前请求url是未配置权限角色的资源，假设业务系统对未配置权限的资源需要登录才能访问，这里对authenticationUserWrapper对象进行检测
			 * 如果authenticationUserWrapper是UsernamePasswordAuthenticationToken实例，说明已经登录，则正常返回即可
			 * 缺省的角色权限的资源如何响应，系统可以根据各自业务需要进行规划，比如直接开放访问，则这里不需要检查登录状态，直接正常返回即可
			 */
			if (AppFilterInvocationSecurityMetadataSource.DEFAULT_CONFIG_ATTRIBUTE.equals(requiredRole)
					//&& authenticationUserWrapper instanceof UsernamePasswordAuthenticationToken 
					) {
				return;
			}

			/*
			 * 如果当前请求的url配置了权限角色，则对用户和url的角色进行比较，如果匹配，则正常返回
			 */
			for (GrantedAuthority userRoleWrapper : userRolesWrapper) {
				String userRole = userRoleWrapper.getAuthority();
				boolean matched = requiredRole.equals(userRole);
				logger.info("当前用户角色权限[" + userRole + "] 是否匹配  URL权限[" + requiredRole + "] => " + (matched));
				if (matched) {
					logger.info("当前用户角色与URL权限角色匹配成功！ ");
					return;
				}
			}
		}

		/*
		 *如果都不符合，则抛出异常，拒绝用户的请求 
		 */
		throw new AccessDeniedException("权限不足");
	}

	/**
	 * @Title: supports
	 * @Description: 一句话描述方法的作用
	 * @param attribute
	 * @return
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		logger.info("调用了AppAccessDecisionManager  ===================>  supports::attribute");
		return true;
	}

	/**
	 * @Title: supports
	 * @Description: 一句话描述方法的作用
	 * @param clazz
	 * @return
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("调用了AppAccessDecisionManager  ===================>  supports::clazz");
		return true;
	}

}
