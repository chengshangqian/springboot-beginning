/**   
 * @Title: Beans.java 
 * @Package com.fandou.springboot.chapter04.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:10:05
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Title: Beans
 * @Description: bean的配置类 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:10:05
 * @version V0.0.1
 */
@Configuration
@ImportResource("classpath:beans.xml")
public class Beans {

}
