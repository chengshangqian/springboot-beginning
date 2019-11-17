/**   
 * @Title: CatReceiverService.java 
 * @Package com.fandou.springboot.rabbitmq.receiver.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:35:18
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.receiver.service;

import com.fandou.springboot.rabbitmq.model.Cat;

/**
 * @Title: CatReceiverService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:35:18
 * @version V0.0.1
 */
public interface CatReceiverService {
	Cat addCat(Cat cat);
}
