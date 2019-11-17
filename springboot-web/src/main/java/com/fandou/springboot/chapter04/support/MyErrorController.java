/**   
 * @Title: MyErrorController.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午10:05:46
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: MyErrorController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午10:05:46
 * @version V0.0.1
 */
@Controller
public class MyErrorController extends BasicErrorController {

	/** 
	 * @Title 构造方法
	 * @Description: TODO(描述构造方法的含义)
	 * @param errorAttributes
	 * @param errorProperties
	 * @param errorViewResolvers 
	 */
	@Autowired
	public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
			List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes, serverProperties.getError(), errorViewResolvers);
	}
	
	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		
		/*
		 * 请求结果状态
		 */
		HttpStatus status = getStatus(request);
		mav.setStatus(status);
		
		/*
		 * 添加自定义错误信息
		 */
		Map<String,Object> model = getErrorAttributes(request, isIncludeStackTrace(request,MediaType.TEXT_HTML));
		//mav.addObject("title", "普通温馨提示");
		model.put("title", "普通温馨提示");
		model.put("errorMsg", "系统异常");
		model.put("errorDesc", "系统程序运行出错了");
		mav.addAllObjects(model);
		
		String errorViewName = "error/common";
		/*自定义错误页面
		if(status.is5xxServerError()) {
			errorViewName = "error/5xx";
		}else if(status.is4xxClientError()) {
			errorViewName = "error/4xx";
		}
		......
		else {
			mav.setViewName("error/common");
		}
		*/
		mav.setViewName(errorViewName);
		
		return mav;
	}
	
	@Override
	public ResponseEntity<Map<String,Object>> error(HttpServletRequest request) {
		Map<String,Object> body = getErrorAttributes(request, isIncludeStackTrace(request,MediaType.ALL));
		body.put("errorMsg", "系统异常");
		body.put("errorDesc", "系统程序运行出错了");
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(body,status);
	}

}
