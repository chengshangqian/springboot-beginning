/**   
 * @Title: GsonConfig.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午1:40:07
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Title: ControllerGolbalConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午1:40:07
 * @version V0.0.1
 */
@ControllerAdvice
public class ControllerGolbalConfig {
	/*
	 * 配置全局参数
	 */
	@ModelAttribute(value="info")
	public Map<String,String> userInfo(){
		Map<String,String> info = new HashMap<String,String>();
		info.put("username", "成九五");
		info.put("sex", "男");
		return info;
	}
}
