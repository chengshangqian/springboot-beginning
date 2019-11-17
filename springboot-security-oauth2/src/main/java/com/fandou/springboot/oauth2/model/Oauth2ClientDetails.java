/**   
 * @Title: Oauth2ClientDetails.java 
 * @Package com.fandou.springboot.oauth2.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午9:29:40
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 * @Title: Oauth2ClientDetails
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午9:29:40
 * @version V0.0.1
 */
public class Oauth2ClientDetails implements ClientDetails {
	
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 904764305349826958L;
	
	private String clientId;
	private Set<String> resourceIds;
	private String clientSecret;
	private Set<String> scope;
	private Set<String> authorizedGrantTypes;
	private Integer accessTokenValiditySeconds = 1800;
	private Integer refreshTokenValiditySeconds = 1800;
	private boolean scoped;
	private boolean secretRequired;
	private Collection<GrantedAuthority> authorities;
	private Set<String> registeredRedirectUri;
	//TODO 更多待实现

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public void setScoped(boolean scoped) {
		this.scoped = scoped;
	}

	public void setSecretRequired(boolean secretRequired) {
		this.secretRequired = secretRequired;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setResourceIds(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	/** 
	 * @Title: getClientId 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public String getClientId() {
		return clientId;
	}

	/** 
	 * @Title: getResourceIds 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	/** 
	 * @Title: isSecretRequired 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public boolean isSecretRequired() {
		return secretRequired;
	}

	/** 
	 * @Title: getClientSecret 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	/** 
	 * @Title: isScoped 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public boolean isScoped() {
		return scoped;
	}

	/** 
	 * @Title: getScope 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Set<String> getScope() {
		return scope;
	}

	/** 
	 * @Title: getAuthorizedGrantTypes 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	/** 
	 * @Title: getRegisteredRedirectUri 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	/** 
	 * @Title: getAuthorities 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/** 
	 * @Title: getAccessTokenValiditySeconds 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	/** 
	 * @Title: getRefreshTokenValiditySeconds 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	/** 
	 * @Title: isAutoApprove 
	 * @Description: 一句话描述方法的作用
	 * @param scope
	 * @return
	 */
	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	/** 
	 * @Title: getAdditionalInformation 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}
