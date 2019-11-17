/**   
 * @Title: Role.java 
 * @Package com.fandou.springboot.db.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:17:14
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.model;

import java.io.Serializable;

/**
 * @Title: Role
 * @Description: 角色类 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:17:14
 * @version V0.0.1
 */
public class Role implements Serializable{
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -354905445786499931L;
	
	private Integer id;
	private String name;
	private String code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
