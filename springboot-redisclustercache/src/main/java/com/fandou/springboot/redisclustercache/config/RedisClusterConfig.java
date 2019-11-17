/**   
 * @Title: RedisClusterConfig.java 
 * @Package com.fandou.springboot.redisclustercache.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月2日 下午9:40:56
 * @version V0.0.1  
 */
package com.fandou.springboot.redisclustercache.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fandou.springboot.redisclustercache.model.Cat;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @Title: RedisClusterConfig
 * @Description: Redis集群连接配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月2日 下午9:40:56
 * @version V0.0.1
 */
@Configuration
@ConfigurationProperties("spring.redis.cluster")
public class RedisClusterConfig {
	
	private Logger logger = LogManager.getLogger(RedisClusterConfig.class);
	List<Integer> ports;
	String host;
	JedisPoolConfig poolConfig;
	
	@Bean
	RedisClusterConfiguration redisClusterConfiguration() {
		logger.info("=======> 加载Redis集群配置");
		RedisClusterConfiguration configuration = new RedisClusterConfiguration();
		List<RedisNode> nodes = new ArrayList<>();
		for(Integer prot : ports) {
			nodes.add(new RedisNode(host,prot));
		}
		configuration.setPassword(RedisPassword.of("123456"));
		configuration.setClusterNodes(nodes);
		return configuration;
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		logger.info("=======> 使用jedisConnectionFactory连接Redis集群");
		JedisConnectionFactory factory = new JedisConnectionFactory(redisClusterConfiguration(),poolConfig);
		return factory;
	}
	
	@Bean
	RedisTemplate<String, Cat> redisTemplate() {
		logger.info("=======> 使用redisTemplate保存对象");
		RedisTemplate<String, Cat> redisTemplate = new RedisTemplate<String, Cat>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		return redisTemplate;
	}
	
	@Bean
	StringRedisTemplate stringRedisTemplate() {
		logger.info("=======> 使用redisTemplate保存字符串");
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory());
		stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
		stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
		return stringRedisTemplate;
	}

	public List<Integer> getPorts() {
		return ports;
	}

	public void setPorts(List<Integer> ports) {
		this.ports = ports;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public JedisPoolConfig getPoolConfig() {
		return poolConfig;
	}

	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}
}
