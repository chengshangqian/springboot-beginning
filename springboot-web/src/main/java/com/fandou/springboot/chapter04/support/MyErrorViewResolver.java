/**   
 * @Title: MyErroViewResolver.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午9:40:25
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: MyErroViewResolver
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午9:40:25
 * @version V0.0.1
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {

	/** 
	 * @Title: resolveErrorView 
	 * @Description: 一句话描述方法的作用
	 * @param request
	 * @param status
	 * @param model
	 * @return
	 */
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "普通温馨提示");
		mav.addAllObjects(model);
		
		/*自定义错误页面
		if(status.is5xxServerError()) {
			mav.setViewName("error/5xx");
		}else if(status.is4xxClientError()) {
			mav.setViewName("error/4xx");
		}
		else {
			mav.setViewName("error/common");
		}
		*/
		
		mav.setViewName("error/common");
		return mav;
	}

}
