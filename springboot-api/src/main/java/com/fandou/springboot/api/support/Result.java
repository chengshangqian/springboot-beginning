/**   
 * @Title: HttpResult.java 
 * @Package com.fandou.springboot.api.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午12:16:10
 * @version V0.0.1  
 */
package com.fandou.springboot.api.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title: HttpResult
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午12:16:10
 * @version V0.0.1
 */
@ApiModel(value = "请求处理结果类",description = "对发起http请求处理结果的状态、代码、描述以及返回数据等信息的包装")
public class Result {
	
	public final static Result SUCCESS = new Result();
	public final static Result FAILURE = new Result("failure", "500", "请求失败");
	
	@ApiModelProperty(value = "请求结果状态",dataType = "string",required = true)
	private String status;
	
	@ApiModelProperty(value = "请求结果编码",dataType = "string",required = false)
	private String code;
	
	@ApiModelProperty(value = "请求结果描述",dataType = "string",required = false)
	private String desc;
	
	@ApiModelProperty(value = "请求结果数据,可能是基本数据类型，也可能是对象、集合等任意类型",dataType = "object",required = false)
	private Object result;
	
	@ApiModelProperty(hidden = true)
	private Object pagintiaon;

	public Result() {
		this.status = "success";
		this.code = "200";
		this.desc = "请求成功";
	}

	public Result(Object result) {
		this();
		this.result = result;
	}
	
	public Result(String status) {
		this.status = status;
	}

	public Result(String status, String code) {
		this(status);
		this.code = code;
	}

	public Result(String status, String code, String desc) {
		this(status, code);
		this.desc = desc;
	}

	public Result(String status, String code, String desc, Object result) {
		this(status, code, desc);
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getPagintiaon() {
		return pagintiaon;
	}

	public void setPagintiaon(Object pagintiaon) {
		this.pagintiaon = pagintiaon;
	}
}
