/**   
 * @Title: WriteOnlyComputerDao.java 
 * @Package com.fandou.springboot.jpa.dao.writeonly
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.dao.writeonly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fandou.springboot.jpa.model.Computer;

/**
 * @Title: WriteOnlyComputerDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1
 */
public interface WriteOnlyComputerDao extends JpaRepository<Computer, Integer> {
	@Query(value="select id,name,model from computer where id = (select max(id) from computer)",nativeQuery=true)
	Computer getLastComputer();
}
