/**   
 * @Title: Hr.java 
 * @Package com.fandou.springboot.vhr.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午9:58:31
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Title: Hr
 * @Description: HR类  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午9:58:31
 * @version V0.0.1
 */
public class Hr implements UserDetails {
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 6998297881035543529L;
	
	private Integer id;
	private String name;
	private String phone;
	private String telephone;
	private String address;
	private String userface;
	private String remark;
	
	private String username;
	private String password;
	private boolean enabled;
	
	private List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserface() {
		return userface;
	}

	public void setUserface(String userface) {
		this.userface = userface;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/** 
	 * @Title: getAuthorities 
	 * @Description: 权限
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
	 * @Title: getPassword 
	 * @Description: 密码
	 * @return
	 */
	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
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

	/** 
	 * @Title: isAccountNonExpired 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	/** 
	 * @Title: isAccountNonLocked 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	/** 
	 * @Title: isCredentialsNonExpired 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/** 
	 * @Title: isEnabled 
	 * @Description: 是否有效账号
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
