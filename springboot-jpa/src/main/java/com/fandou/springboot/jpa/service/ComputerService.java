/**   
 * @Title: ComputerService.java 
 * @Package com.fandou.springboot.jpa.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午12:13:24
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.service;

import com.fandou.springboot.jpa.model.Computer;

/**
 * @Title: ComputerService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午12:13:24
 * @version V0.0.1
 */
public interface ComputerService {
	Computer getMaxIdComputer();
	Computer getLastComputer();
	Computer addComputer(Computer computer);
}
