/**   
 * @Title: MyErrorAttributes.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午9:10:10
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * @Title: MyErrorAttributes
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午9:10:10
 * @version V0.0.1
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
	@Override
	public Map<String,Object> getErrorAttributes(WebRequest webRequest,boolean includeStackTrace){
		Map<String,Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		errorAttributes.put("desc", "系统开小差了");
		//errorAttributes.remove("error");
		return errorAttributes;
	}
}
