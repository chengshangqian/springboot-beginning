/**   
 * @Title: Cat.java 
 * @Package com.fandou.springboot.devtools.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午7:39:22
 * @version V0.0.1  
 */
package com.fandou.springboot.devtools.model;

/**
 * @Title: Cat
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午7:39:22
 * @version V0.0.1
 */
public class Cat {
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
