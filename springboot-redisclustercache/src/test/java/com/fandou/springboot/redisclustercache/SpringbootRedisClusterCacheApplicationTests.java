package com.fandou.springboot.redisclustercache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.redisclustercache.model.Cat;
import com.fandou.springboot.redisclustercache.service.CatService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisClusterCacheApplicationTests {
	private Logger logger = LogManager.getLogger(SpringbootRedisClusterCacheApplicationTests.class);
	
	@Autowired
	CatService catService;

	@Test
	public void contextLoads() {
		//规划使用对象的唯一ID（值）作为缓存的key
		Integer key = 1;
		
		Cat dbCat = catService.getCatById(key);//从数据库中查询数据返回，结果同时被缓存
		Cat cachedCat = catService.getCatById(key);//第二次调用该方法查询，命中缓存（key），直接返回缓存中的对象，而不会查询数据库，即该方法实际上不会被调用
		logger.info("dbCat.equals(cachedCat) => " + dbCat.equals(cachedCat));//false:与ehcache不一样，可能是重新反序列化生成新对象返回
		
		/*
		 * 从数据库中删除数据，若命中缓存（key），将同时删除缓存中的对象
		 */
		catService.deleteCatById(key);
		
		/*
		 * 缓存对象删除后，再次调用该方法，将重新从数据库中查询（这里返回对象，仅为了模拟重新查询而不是从缓存直接返回）
		 */
		Cat jerry =  catService.getCatById(key);
		logger.info("dbCat.equals(jerry) => " + dbCat.equals(jerry));//false
		
		/*
		 * 更新数据库数据（name => Tom,color => Blue)
		 * 若命中缓存（key），将同时更新(覆盖)缓存中的数据
		 */
		Cat tom = new Cat();
		tom.setId(key);
		tom.setName("Tom");
		catService.updateCatById(tom);
		
		/*
		 * 更新后的缓存的对象与之前的缓存的对象、用来更新的对象比较结果
		 */
		Cat newCachedCat =  catService.getCatById(key);
		String prefixKeyConfiged = "c95:";
		logger.info(prefixKeyConfiged + key + " => {" + newCachedCat.getId() + "," + newCachedCat.getName() + "," + newCachedCat.getColor() + "}");
		logger.info("newCachedCat.equals(jerry) => " + newCachedCat.equals(jerry));//false
		logger.info("newCachedCat.equals(tom) => " + newCachedCat.equals(tom));//false:与ehcache不一样，可能是重新反序列化生成新对象返回
		
		Integer id = 100;
		Cat defaultCacheConfigCat =  catService.loadCatById(id);
		logger.info("default_cache_config::" + id + " => {" + defaultCacheConfigCat.getId() + "," + defaultCacheConfigCat.getName() + "," + defaultCacheConfigCat.getColor() + "}");
		
		/*
		 * 从数据库中删除数据，若命中缓存（key），将同时删除缓存中的对象
		 */
		//catService.deleteCatById(key);
	}

}
