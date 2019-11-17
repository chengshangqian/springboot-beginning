/**   
 * @Title: IndexControllerTest.java 
 * @Package com.fandou.springboot.devtools 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午9:06:15
 * @version V0.0.1  
 */
package com.fandou.springboot.devtools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.devtools.model.Cat;

/**
 * @Title: IndexControllerTest
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午9:06:15
 * @version V0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IndexControllerTest {
	private Logger logger = LogManager.getLogger(IndexControllerTest.class);
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void test3() {
		ResponseEntity<Cat> getCat = restTemplate.getForEntity("/cat?name={0}", Cat.class,"杰西");
		Cat cat = getCat.getBody();
		logger.debug("result => " + cat.getColor());
	}
}
