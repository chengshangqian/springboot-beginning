/**   
 * @Title: Menu.java 
 * @Package com.fandou.springboot.db.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午5:33:34
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: Menu
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午5:33:34
 * @version V0.0.1
 */
public class Menu implements Serializable{
	
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -4750835458461364873L;
	
	private Integer id;
	private String url;
	private String path;
	private String component;
	private String name;
	private String iconCls;
	private boolean keepAlive;
	private boolean requireAuth;
	private Integer parentId;
	private boolean enabled;
	private List<Role> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public boolean isKeepAlive() {
		return keepAlive;
	}
	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}
	public boolean isRequireAuth() {
		return requireAuth;
	}
	public void setRequireAuth(boolean requireAuth) {
		this.requireAuth = requireAuth;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
