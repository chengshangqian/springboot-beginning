/**   
 * @Title: Cat.java 
 * @Package com.fandou.springboot.api.model 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午10:27:23
 * @version V0.0.1  
 */
package com.fandou.springboot.api.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title: Cat
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午10:27:23
 * @version V0.0.1
 */
@ApiModel(value = "猫咪类",description = "猫咪的描述信息类")
public class Cat {
	@ApiModelProperty(value = "猫咪主键id",dataType = "int")
	private Integer id;
	
	@ApiModelProperty(value = "猫咪名称",dataType = "string")
	private String name;
	
	@ApiModelProperty(value = "猫咪颜色",dataType = "string")
	private String color;
	
	@ApiModelProperty(hidden = true)
	private Date createDate;
	
	@ApiModelProperty(hidden = true)
	private Date updateDate;
	
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
