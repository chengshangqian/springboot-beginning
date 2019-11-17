/**   
 * @Title: CatServiceImpl.java 
 * @Package com.fandou.springboot.redis.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:07:55
 * @version V0.0.1  
 */
package com.fandou.springboot.rediscluster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fandou.springboot.rediscluster.model.Cat;
import com.fandou.springboot.rediscluster.service.CatService;

/**
 * @Title: CatServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:07:55
 * @version V0.0.1
 */
@Service
public class CatServiceImpl implements CatService {
	
	@Autowired
	RedisTemplate<String,Cat> redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	/** 
	 * @Title: saveCatName 
	 * @Description: 一句话描述方法的作用
	 * @param key
	 * @param name
	 */
	@Override
	public void saveCatName(String key, String name) {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set(key, name);
	}

	/** 
	 * @Title: saveCat 
	 * @Description: 一句话描述方法的作用
	 * @param key
	 * @param cat
	 */
	@Override
	public void saveCat(String key, Cat cat) {
		ValueOperations<String, Cat> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, cat);
	}

	/** 
	 * @Title: getCatName 
	 * @Description: 一句话描述方法的作用
	 * @param key
	 * @return
	 */
	@Override
	public String getCatName(String key) {
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		return valueOperations.get(key);
	}

	/** 
	 * @Title: getCat 
	 * @Description: 一句话描述方法的作用
	 * @param key
	 * @return
	 */
	@Override
	public Cat getCat(String key) {
		ValueOperations<String, Cat> valueOperations = redisTemplate.opsForValue();
		return valueOperations.get(key);
	}
}
