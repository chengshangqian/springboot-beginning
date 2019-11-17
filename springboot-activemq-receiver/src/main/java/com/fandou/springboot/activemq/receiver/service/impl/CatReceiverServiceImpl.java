/**   
 * @Title: CatReceiverImpl.java 
 * @Package com.fandou.springboot.activemq.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:42:29
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.receiver.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fandou.springboot.activemq.model.Cat;
import com.fandou.springboot.activemq.receiver.dao.CatDao;
import com.fandou.springboot.activemq.receiver.service.CatReceiverService;

/**
 * @Title: CatReceiverImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:42:29
 * @version V0.0.1
 */
@Service
public class CatReceiverServiceImpl implements CatReceiverService {
	private Logger logger = LogManager.getLogger(CatReceiverServiceImpl.class);
	
	@Autowired
	CatDao catDao;
	
	/**
	 * @Title: addCat 
	 * @Description: 异步多线程保存消息
	 * @param cat
	 * @return
	 */
	@Async
	public Cat addCat(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("CatReceiverServiceImpl.addCat :: threadName => " + threadName);
		return catDao.addCat(cat);
	}

	/** 
	 * @Title: addCatOneThread 
	 * @Description: 单线程保存消息
	 * @param cat
	 * @return
	 */
	@Override
	public Cat addCatOneThread(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("CatReceiverServiceImpl.addCatOneThread :: threadName => " + threadName);		
		return catDao.addCat(cat);
	}
}
