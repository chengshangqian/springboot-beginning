/**   
 * @Title: C95Servlet.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:23:58
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Title: C95Servlet
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:23:58
 * @version V0.0.1
 */
@WebServlet("/servlet")
public class C95Servlet extends HttpServlet {
	private Logger logger = LogManager.getLogger(C95Servlet.class);
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 7968505307873418266L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("C95Servlet name => " + request.getParameter("name"));
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request,response);
	}
}
