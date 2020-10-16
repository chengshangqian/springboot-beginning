package com.fandou.springboot.rabbitmq.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class ThreadAspect {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadAspect.class);

    @Pointcut("@annotation(com.fandou.springboot.rabbitmq.support.PrintThread)")
    public void threadPointCut(){

    }

    @Before("threadPointCut()")
    public void printThread(JoinPoint point){
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        PrintThread doLog = method.getAnnotation(PrintThread.class);
        if (null != doLog) {
            String info = doLog.value();
            String className = point.getTarget().getClass().getName();
            String methodName = methodSignature.getName();
            String params = "";
            Object[] args = point.getArgs();
            if(null != args && args.length > 0) {
                try {
                    params = new ObjectMapper().writeValueAsString(args);
                } catch (JsonProcessingException e) {
                    LOGGER.warn("获取方法参数失败:",e.getMessage());
                }
            }

            if(LOGGER.isDebugEnabled()){
                String threadName = Thread.currentThread().getName();
                LOGGER.debug("线程[{}]调用了[{}]方法({})...",threadName,className + "." + methodName,info);
                if (null != params && params.length() > 0) {
                    LOGGER.debug("方法参数 -> {}",params);
                }
            }
        }
    }
}
