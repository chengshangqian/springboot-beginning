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
package com.fandou.springboot.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fandou.springboot.redis.model.Cat;
import com.fandou.springboot.redis.service.CatService;

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
	RedisTemplate redisTemplate;

	private static final String KEY = "REDIS_DATA_CAT_";

	public Cat get(Long id){
		return getValueOperations().get(KEY + id);
	}

	public void create(Cat cat){
		getValueOperations().set(KEY + cat.getId(),cat);
	}

	public void update(Cat cat){
		getValueOperations().setIfPresent(KEY + cat.getId(),cat);
	}

	public void delete(Long id){
		getValueOperations().getOperations().delete(KEY + id);
	}

	public  ValueOperations<String,Cat> getValueOperations(){
		ValueOperations<String,Cat> vo = redisTemplate.opsForValue();
		return vo;
	}
}
