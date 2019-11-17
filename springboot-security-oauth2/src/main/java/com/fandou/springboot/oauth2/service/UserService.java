/**   
 * @Title: UserService.java 
 * @Package com.fandou.springboot.db.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:55:49
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Title: UserService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:55:49
 * @version V0.0.1
 */
public interface UserService extends UserDetailsService {
	//User loadUserByUsername(String username);
	//List<Role> getUserRolesByUid(Integer id);
}
