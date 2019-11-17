/**   
 * @Title: Cat.java 
 * @Package com.fandou.springboot.redis.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午11:59:51
 * @version V0.0.1  
 */
package com.fandou.springboot.redisclustercache.model;

import java.io.Serializable;

/**
 * @Title: Cat
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午11:59:51
 * @version V0.0.1
 */
public class Cat implements Serializable{
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -1122863804909793019L;
	
	private Integer id;
	private String name;
	private String color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
