/**   
 * @Title: ComputerService.java 
 * @Package com.fandou.springboot.jdbc.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:56:29
 * @version V0.0.1  
 */
package com.fandou.springboot.mybatis.service;

import java.util.List;

import com.fandou.springboot.mybatis.model.Computer;

/**
 * @Title: ComputerService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:56:29
 * @version V0.0.1
 */
public interface ComputerService {
	int addComputer(Computer computer);
	List<Computer> getAllComputers();
}
