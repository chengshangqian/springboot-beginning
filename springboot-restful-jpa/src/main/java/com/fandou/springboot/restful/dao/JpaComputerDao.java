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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fandou.springboot.restful.model.Computer;

/**
 * @Title: JpaComputerDao
 * @Description: 继承JpaRepository实现JPA数据层组件的整合
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1
 */
//使用注解自定义请求路径path和返回的对象引用名字[,屏蔽所有接口]
//@RepositoryRestResource(path="coms",collectionResourceRel = "coms",itemResourceRel = "com"[,exported=false])
@RepositoryRestResource(path="jpa")
public interface JpaComputerDao extends JpaRepository<Computer, Integer> {
	
	//单独屏蔽DELETE接口（JPA）
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	//自定义查询方法:http://localhost:8081/api/jpa/search/computers?name=HP
	@RestResource(path="computers",rel="name")
	Computer findByNameEquals(@Param("name") String name);
}
