/**   
 * @Title: UploadExceptionHandler.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午6:09:52
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: UploadExceptionHandler
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月28日 下午6:09:52
 * @version V0.0.1
 */
@ControllerAdvice
public class UploadExceptionHandler {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView uploadException(MaxUploadSizeExceededException ex,HttpServletResponse resp) throws IOException {
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.write("上传文件大小超出限制...");
//		out.flush();
//		out.close();
		ModelAndView mav = new ModelAndView("error/error");
		mav.addObject("msg","上传文件大小超出限制");
		return mav;
	}
	

}
