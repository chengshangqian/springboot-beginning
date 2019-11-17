/**   
 * @Title: Book.java 
 * @Package com.fandou.springboot.chapter02 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午9:46:44
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter02;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: Book
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午9:46:44
 * @version V0.0.1
 */
@Component
@ConfigurationProperties(prefix="user")
public class PropertiesUser {
	private String name;
	private String address;
	private List<String> favorites;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}
}
