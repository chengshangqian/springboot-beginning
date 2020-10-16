/**   
 * @Title: CatController.java 
 * @Package com.fandou.springboot.redis.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:01:32
 * @version V0.0.1  
 */
package com.fandou.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fandou.springboot.redis.model.Cat;
import com.fandou.springboot.redis.service.CatService;

/**
 * @Title: RedisController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:01:32
 * @version V0.0.1
 */
@RestController
@RequestMapping("/cats")
public class CatController {
	@Autowired
	CatService catService;
	
	/**********Redis(Jedis) 操作**********/
	@GetMapping("/{id}")
	public Cat get(@PathVariable("id") Long id) {
		return catService.get(id);
	}
	
	@PostMapping
	public Cat create(@RequestBody Cat cat) {
		catService.create(cat);
		return cat;
	}
	
	@PutMapping
	public Long update(@RequestBody Cat cat) {
		catService.update(cat);
		return cat.getId();
	}
	
	@DeleteMapping("/{id}")
	public Long delete(@PathVariable("id") Long id) {
		catService.delete(id);
		return id;
	}
}
