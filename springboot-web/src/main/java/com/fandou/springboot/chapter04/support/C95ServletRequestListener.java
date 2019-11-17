/**   
 * @Title: C95Listener.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:32:52
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Title: C95Listener
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:32:52
 * @version V0.0.1
 */
@WebListener
public class C95ServletRequestListener implements ServletRequestListener {
	private Logger logger = LogManager.getLogger(C95ServletRequestListener.class);
	public void requestInitialized(ServletRequestEvent evn) {
		logger.debug("C95ServletRequestListener => requestInitialied");
	}
	
	public void requestDestroyed(ServletRequestEvent evn) {
		logger.debug("C95ServletRequestListener => requestDestroyed");
	}
	
}
