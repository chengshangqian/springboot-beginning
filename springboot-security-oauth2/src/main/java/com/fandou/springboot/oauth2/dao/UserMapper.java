/**   
 * @Title: UserMapper.java 
 * @Package com.fandou.springboot.oauth2.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:24:34
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fandou.springboot.oauth2.model.Role;
import com.fandou.springboot.oauth2.model.User;

/**
 * @Title: UserMapper
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:24:34
 * @version V0.0.1
 */
@Mapper
public interface UserMapper {
	User loadUserByUsername(String username);
	List<Role> getUserRolesByUid(Integer id);
}
