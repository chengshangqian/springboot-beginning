/**   
 * @Title: RedisCacheConfig.java 
 * @Package com.fandou.springboot.redisclustercache.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午11:23:35
 * @version V0.0.1  
 */
package com.fandou.springboot.redisclustercache.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @Title: RedisCacheConfig
 * @Description: Redis缓存管理配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午11:23:35
 * @version V0.0.1
 */
@Configuration
public class RedisCacheConfig {
	
	/*
	 * redisConnectionFactory 注入redis集群连接，其实现类的配置见RedisClusterConfig文件
	 */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisCacheManager redisCacheManager() {
    	
    	/*
    	 * redisCacheConfigurationNames 自定义缓存策略/配置名称列表
    	 */
        Map<String, RedisCacheConfiguration> redisCacheConfigurationNames = new HashMap<>();
        
        /*
         * redisCacheConfig 自定义缓存策略/配置，将以cat_cache名字保存和加载
         */
        RedisCacheConfiguration redisCacheConfig =
                RedisCacheConfiguration.defaultCacheConfig()
                        .prefixKeysWith("c95:")
                        .disableCachingNullValues()
                        .entryTtl(Duration.ofMinutes(30));
        
        /*
         * cat_cache 将自定义缓存策略/配置以cat_cache名字保存
         */
        redisCacheConfigurationNames.put("cat_cache", redisCacheConfig);
        
        /*
         * cacheWriter 缓存写入器
         */
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        
        /*
         * redisCacheManager 缓存管理器
         */
        RedisCacheManager redisCacheManager =
                new RedisCacheManager(
                        redisCacheWriter,//缓存写入器
                        RedisCacheConfiguration.defaultCacheConfig(),//备用的默认缓存策略/配置
                        redisCacheConfigurationNames);//自定义缓存策略/配置
        
        return redisCacheManager;
    }
}
