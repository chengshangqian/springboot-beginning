/**   
 * @Title: CatService.java 
 * @Package com.fandou.springboot.activemq.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:36:00
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.sender.service;

import com.fandou.springboot.activemq.model.Cat;

/**
 * @Title: CatService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:36:00
 * @version V0.0.1
 */
public interface CatSenderService {
	void send(Cat cat);
}
