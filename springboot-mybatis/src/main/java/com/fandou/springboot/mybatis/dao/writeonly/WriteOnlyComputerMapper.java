/**   
 * @Title: ComputerMapper.java 
 * @Package com.fandou.springboot.chapter05.model.mapper 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:08:28
 * @version V0.0.1  
 */
package com.fandou.springboot.mybatis.dao.writeonly;

import com.fandou.springboot.mybatis.model.Computer;

/**
 * @Title: ComputerMapper
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:08:28
 * @version V0.0.1
 */
public interface WriteOnlyComputerMapper {
	int addComputer(Computer computer);
	int deleteComputer(Integer id);
	int updateComputer(Computer computer);
}
