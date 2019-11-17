/**   
 * @Title: CatDao.java 
 * @Package com.fandou.springboot.ehcache.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:04:49
 * @version V0.0.1  
 */
package com.fandou.springboot.ehcache.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.fandou.springboot.ehcache.model.Cat;

/**
 * @Title: CatDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:04:49
 * @version V0.0.1
 */
@Repository
@CacheConfig(cacheNames="cat_cache")
public class CatDao {
	private Logger logger = LogManager.getLogger(CatDao.class);
	/** 
	 * @Title: getCatById 
	 * @Description: 根据ID从数据库中查询数据返回 ：Cacheable注解每次调用前会检查是否有缓存，如有，则直接返回缓存中的数据且方法不会被调用
	 * @param id
	 * @return
	 */
	@Cacheable
	public Cat getCatById(Integer id) {
		logger.info("Invoke getCatById => " + id);
		
		//以下模拟从数据库中查询数据返回，使用了缓存组件后，查询结果将被缓存
		//缓存后，再次调用此方法，如果id相同，缓存中若存在相同id的缓存值，将直接从缓存中返回结果，不会再次查询数据库
		Cat cat = new Cat();
		cat.setId(id);
		cat.setName("Jerry");
		cat.setColor("Yellow");
		
		return cat;
	}

	/** 
	 * @Title: updateCatById 
	 * @Description: 更新到数据库，如果缓存中存在相同id的对象，则同时更新缓存中对象：CachePut注解每次调用前不会检查缓存，返回结果时检查缓存，如命中则同时更新缓存数据
	 * @param cat
	 * @return
	 */
	@CachePut(key="#cat.id")
	public Cat updateCatById(Cat cat) {
		logger.info("Invoke updateCatById => " + cat.getId());
		cat.setColor("Blue");
		return cat;
	}

	/** 
	 * @Title: deleteCatById 
	 * @Description: 从数据库中删除数据，如果缓存中存在相同id的对象，则同时从缓存中删除对象：CacheEvict
	 * @param id
	 */
	@CacheEvict(key="#id")
	public void deleteCatById(Integer id) {
		logger.info("deleteCatById => " + id);
		//TODO 从数据库删除数据，代码略
	}
}
