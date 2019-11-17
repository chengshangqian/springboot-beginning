/**   
 * @Title: CatReciever.java 
 * @Package com.fandou.springboot.activemq.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:39:43
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.receiver.service;

import com.fandou.springboot.activemq.model.Cat;

/**
 * @Title: CatReciever
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:39:43
 * @version V0.0.1
 */
public interface CatReceiverService {
	Cat addCat(Cat cat);
	Cat addCatOneThread(Cat cat);
}
