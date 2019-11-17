/**   
 * @Title: Cookbook.java 
 * @Package com.fandou.springboot.chapter05.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:06:50
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.model;

/**
 * @Title: Cookbook
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:06:50
 * @version V0.0.1
 */
public class Book {
	private Integer id;
	private String name;
	private String author;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
