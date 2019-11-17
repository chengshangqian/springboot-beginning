/**   
 * @Title: Oauth2ClientDetailsServiceImpl.java 
 * @Package com.fandou.springboot.oauth2.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午9:27:30
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.fandou.springboot.oauth2.model.Oauth2ClientDetails;
import com.fandou.springboot.oauth2.service.Oauth2ClientDetailsService;

/**
 * @Title: Oauth2ClientDetailsServiceImpl
 * @Description: 第三方应用详情信息服务
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午9:27:30
 * @version V0.0.1
 */
@Service
public class Oauth2ClientDetailsServiceImpl implements Oauth2ClientDetailsService {
	private Logger logger = LogManager.getLogger(Oauth2ClientDetailsServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;//在AppSecurityConfig类配置

	/** 
	 * @Title: loadClientByClientId 
	 * @Description: 加载第三方应用在系统登记注册的信息：获取一次token要调用4次此方法？
	 * @param clientId
	 * @return
	 * @throws ClientRegistrationException
	 */
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		logger.info("调用了Oauth2ClientDetailsServiceImpl  ===================>  loadClientByClientId");
		
		//TODO 从数据库中查询在本应用中备案登记的第三方应用：client_id\client_secret\scope\resourceIds等等，以下仅演示
		/* 
		Oauth2ClientDetails oauth2ClientDetails = oauth2ClientDetailsMapper.loadClientByClientId(clientId);

        if(null == oauth2ClientDetails) {
            throw new ClientRegistrationException("应用" + clientId + "不存在!");
        }
        
        return oauth2ClientDetails;
        */
		
		//for test
		Oauth2ClientDetails oauth2ClientDetails = new Oauth2ClientDetails();
		oauth2ClientDetails.setClientId("password-client");
		oauth2ClientDetails.setClientSecret(passwordEncoder.encode("888888"));
		
		Set<String> resourceIds = new HashSet<String>();
		resourceIds.add("open-api");
		//resourceIds.add("more-resoures");
		oauth2ClientDetails.setResourceIds(resourceIds);
		
		Set<String> scope = new HashSet<String>();
		scope.add("all");
		//scope.add("read");
		//scope.add("write");
		//scope.add("more");
		oauth2ClientDetails.setScope(scope);
		oauth2ClientDetails.setScoped(true);
		
		Set<String> authorizedGrantTypes = new HashSet<String>();
		authorizedGrantTypes.add("password");
		authorizedGrantTypes.add("refresh_token");
		//authorizedGrantTypes.add("or others");
		oauth2ClientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		
		/**
		 * authorities需要编写验证代码时有作用，默认情况下，其权限与传递的用户权限相关
		 */
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_admin"));
		authorities.add(new SimpleGrantedAuthority("ROLE_user"));
		//authorities.add(new SimpleGrantedAuthority("admin"));
		//authorities.add(new SimpleGrantedAuthority("user"));
		oauth2ClientDetails.setAuthorities(authorities);
		
		oauth2ClientDetails.setAccessTokenValiditySeconds(1800);
		oauth2ClientDetails.setRefreshTokenValiditySeconds(1800);
		
		return oauth2ClientDetails;
	}

}
