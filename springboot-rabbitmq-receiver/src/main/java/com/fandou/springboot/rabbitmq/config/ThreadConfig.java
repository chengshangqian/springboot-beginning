/**   
 * @Title: TheadConfig.java 
 * @Package com.fandou.springboot.activemq.receiver.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午10:33:50
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Title: TheadConfig
 * @Description: 启用多线程保存消息  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午10:33:50
 * @version V0.0.1
 */
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer{

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadConfig.class);
	
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(500);
        executor.setKeepAliveSeconds(30000);
        executor.initialize();
        return executor;
    }
 
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        LOGGER.warn("[thread - {}] Async Uncaught Exception....", Thread.currentThread().getName());
        return null;
    }
}
