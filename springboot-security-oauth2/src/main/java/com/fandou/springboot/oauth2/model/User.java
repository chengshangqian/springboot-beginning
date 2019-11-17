/**   
 * @Title: User.java 
 * @Package com.fandou.springboot.db.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:16:47
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Title: User
 * @Description: 用户类 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:16:47
 * @version V0.0.1
 */
public class User implements UserDetails{
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 4001094837997137344L;
	
	private Integer id;
	private String username;
	private String password;
	private boolean enabled;
	private boolean locked;
	private List<Role> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @Title: getUsername 
	 * @Description: 账号
	 * @return
	 */
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @Title: getPassword 
	 * @Description: 密码
	 * @return
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @Title: isEnabled 
	 * @Description:当前账户是否可用
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	/** 
	 * @Title: getAuthorities 
	 * @Description: 当前用户拥有的角色：用户登录成功后将被调用并放入认证用户信息中
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> userRolesWrapper = new ArrayList<>();
		for(Role userRole : roles) {
			userRolesWrapper.add(new SimpleGrantedAuthority(userRole.getCode()));
		}
		return userRolesWrapper;
	}
	
	/** 
	 * @Title: isAccountNonExpired 
	 * @Description: 当前账户是否未过期
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/** 
	 * @Title: isAccountNonLocked 
	 * @Description: 当前账户是否未锁定
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}
	
	/** 
	 * @Title: isCredentialsNonExpired 
	 * @Description: 当前账户密码是否未过期
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
