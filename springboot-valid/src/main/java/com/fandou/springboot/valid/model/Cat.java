/**   
 * @Title: Cat.java 
 * @Package com.fandou.springboot.valid.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午7:32:34
 * @version V0.0.1  
 */
package com.fandou.springboot.valid.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Title: Cat
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午7:32:34
 * @version V0.0.1
 */
public class Cat {
	@NotNull(message="{cat.name.notnull}")
	@Size(min=4,max=20,message="{cat.name.size}")
	private String name;
	
	@NotNull(message="{cat.email.notnull}")
	@Email(message="{cat.email.pattern}")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
