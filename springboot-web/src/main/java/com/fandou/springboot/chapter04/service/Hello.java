/**   
 * @Title: Hello.java 
 * @Package com.fandou.springboot.chapter04.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:13:44
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.service;

/**
 * @Title: Hello
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:13:44
 * @version V0.0.1
 */
public interface Hello {
	String sayHello(String username);
	String add(String id);
	String delete(String id);
	String throwException(String id);
}
