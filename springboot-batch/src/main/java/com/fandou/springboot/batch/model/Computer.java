/**   
 * @Title: Computer.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午7:18:55
 * @version V0.0.1  
 */
package com.fandou.springboot.batch.model;

/**
 * @Title: Computer
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午7:18:55
 * @version V0.0.1
 */
public class Computer {
	private Integer id;
	private String name;
	private String model;
	private String desc = "不是数据表字段";
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
