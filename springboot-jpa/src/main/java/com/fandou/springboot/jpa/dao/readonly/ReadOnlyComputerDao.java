/**   
 * @Title: ReadOnlyComputerDao.java 
 * @Package com.fandou.springboot.jpa.dao.readonly 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.dao.readonly;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fandou.springboot.jpa.model.Computer;

/**
 * @Title: ReadOnlyComputerDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1
 */
public interface ReadOnlyComputerDao extends JpaRepository<Computer, Integer> {
	List<Computer> getComputerByNameStartingWith(String name);
	
	@Query(value="select id,name,model from computer where id = (select max(id) from computer)",nativeQuery=true)
	Computer getMaxIdComputer();
	
	@Query(value="select b from computer b where b.id > :id and b.name = :name")
	List<Computer> getComputerByIdAndName(@Param("id")Integer id,@Param("name")String name);
	
	@Query(value="select b from computer b where b.id < ?2 and b.name like %?1%")
	List<Computer> getComputerByNameAndId(String name,Integer id);
}
