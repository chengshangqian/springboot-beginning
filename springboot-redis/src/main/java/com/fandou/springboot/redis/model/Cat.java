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
package com.fandou.springboot.redis.model;

import lombok.Data;

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
@Data
public class Cat implements Serializable{
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -1122863804909793019L;
	
	private Long id;
	private String name;
	private String color;
}
