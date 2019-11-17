/**   
 * @Title: LogAspect.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午5:06:39
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Title: LogAspect
 * @Description: 方法运行日志切面类
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午5:06:39
 * @version V0.0.1
 */
@Component
@Aspect
public class LogAspect {
	private Logger logger = LogManager.getLogger(LogAspect.class);
	/**
	 * @Title: pointcut 
	 * @Description: 切入点
	 */
	@Pointcut("execution(* com.fandou.springboot.*.service.impl.*.*(..))")
	public void pointcut() {
		logger.debug("切入点...");
	}
	
	/**
	 * @Title: before 
	 * @Description: 前置通知
	 * @param jp
	 */
	@Before(value="pointcut()")
	public void before(JoinPoint jp) {
		logger.debug("Target Class Name ====> " + jp.getTarget().getClass().getName());
		logger.debug("this Class Name ====> " + jp.getThis().getClass().getName());
		String name = jp.getSignature().getName();
		logger.debug("[" + name + "]方法开始执行...");
	}
	
	/**
	 * @Title: after 
	 * @Description: 后置通知
	 * @param jp
	 */
	@After(value="pointcut()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().getName();
		logger.debug("[" + name + "]方法执行结束...");
	}
	
	/**
	 * @Title: afterReturning 
	 * @Description: 返回通知
	 * @param jp
	 * @param result
	 */
	@AfterReturning(value="pointcut()",returning="result")
	public void afterReturning(JoinPoint jp,Object result) {
		String name = jp.getSignature().getName();
		logger.debug("[" + name + "]方法返回值 => " + result);
	}
	
	/**
	 * @Title: afterThrowing 
	 * @Description: 抛异常通知
	 * @param jp
	 * @param ex
	 */
	@AfterThrowing(value="pointcut()",throwing="ex")
	public void afterThrowing(JoinPoint jp,Exception ex) {
		String name = jp.getSignature().getName();
		logger.debug("[" + name + "]方法抛异常  => " + ex.getMessage());
	}
	
	/**
	 * @Title: around 
	 * @Description: 环绕通知
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String name = pjp.getSignature().getName();
		logger.debug("around[" + name + "]方法环绕通知");
		return pjp.proceed();
	}
}
