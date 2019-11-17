/**   
 * @Title: IndexServiceImpl.java 
 * @Package com.fandou.springboot.devtools.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午3:06:55
 * @version V0.0.1  
 */
package com.fandou.springboot.devtools.service.impl;

import org.springframework.stereotype.Service;

import com.fandou.springboot.devtools.service.IndexService;

/**
 * @Title: IndexServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午3:06:55
 * @version V0.0.1
 */
@Service
public class IndexServiceImpl implements IndexService {

	/** 
	 * @Title: say 
	 * @Description: 一句话描述方法的作用
	 * @param sth
	 * @return
	 */
	@Override
	public String say(String sth) {
		String something = null == sth ? "C95" : sth;
		return "Hello," + something;
	}

}
