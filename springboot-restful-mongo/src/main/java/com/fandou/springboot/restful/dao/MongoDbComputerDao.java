/**   
 * @Title: ReadOnlyComputerDao.java 
 * @Package com.fandou.springboot.jpa.dao.readonly 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1  
 */
package com.fandou.springboot.restful.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fandou.springboot.restful.model.Computer;

/**
 * @Title: MongoDbComputerDao
 * @Description: 继续 MongoRepository实现与MongoDB数据库的整合
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1
 */
//使用注解自定义请求路径path和返回的对象引用名字[,屏蔽所有接口]
//@RepositoryRestResource(path="coms",collectionResourceRel = "coms",itemResourceRel = "com"[,exported=false])
//@RepositoryRestResource(path="/mgdb")
public interface MongoDbComputerDao extends MongoRepository<Computer, Integer> {
	
	//单独屏蔽DELETE接口
	//@Override
	//@RestResource(exported=false)
	//void deleteById(Integer id);
	
	//自定义查询方法:http://localhost:8080/api/computers/search/find?name=HP
	@RestResource(path="find",rel="name")
	Computer findByNameEquals(@Param("name") String name);
}
