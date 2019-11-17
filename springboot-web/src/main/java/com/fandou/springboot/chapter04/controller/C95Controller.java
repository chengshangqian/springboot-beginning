/**   
 * @Title: C95Controller.java 
 * @Package com.fandou.springboot.chapter04.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:19:54
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fandou.springboot.chapter04.model.Cat;
import com.fandou.springboot.chapter04.model.Computer;
import com.fandou.springboot.chapter04.service.Hello;

/**
 * @Title: C95Controller
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:19:54
 * @version V0.0.1
 */
@RestController
@ControllerAdvice
public class C95Controller {
	private Logger logger = LogManager.getLogger(C95Controller.class);
	@Autowired
	Hello hello;//使用xml方式配置的bean
	
	@GetMapping("/hi")
	public String sayHello() {
		String result = hello.sayHello("成尚谦");
		logger.debug("===> sayHello");
		return result;
	}
	
	/**
	 * @Title: info 
	 * @Description: 获取全局配置的对象
	 * @return
	 */
	@GetMapping("/info")
	public Object info(Model model) {
		Map<String,Object> map = model.asMap();
		Object info = map.get("info");
		logger.debug("info => " + info);
		return info;
	}
	
	/*
	 * 预处理请求参数
	 */
	@InitBinder("cat")
	public void initCat(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("cat.");
	}
	
	@InitBinder("computer")
	public void initComputer(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("computer.");
	}
	
	/**
	 * @Title: mix 
	 * @Description: 接收多个对象，且有重名的属性（name）
	 * 使用这样的方式传入参数亦可保证正确接收：http://localhost:8080/mix?cat.name=Jerry&color=yellow&computer.name=thinkpad&model=x230
	 * @param cat
	 * @param computer
	 * @return
	 */
	@GetMapping("/mix")
	public Object mix(@ModelAttribute("cat")Cat cat,@ModelAttribute("computer")Computer computer) {
		return "{cat => {" + cat.getName() + "," + cat.getColor() + "} , computer =>  {" + computer.getName() + "," + computer.getModel() + "}";
	}
	
	@GetMapping("/get500")
	public String get500() {
		int i = 1 / 0 ;
		logger.debug("i => " + i);
		return "500";
	}
	
	@RequestMapping("/input/{modelViewName}")
	public ModelAndView create(@PathVariable String modelViewName) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("action", "/"+modelViewName + "/create");
		mav.setViewName(modelViewName + "/input");
		return mav;
	}
	
	@RequestMapping("/input/{modelViewName}/{modelId}")
	public ModelAndView update(@PathVariable String modelViewName,@PathVariable String modelId) {
		ModelAndView mav = new ModelAndView();
		//TODO 从数据库中根据Id查找需要修改的记录
		mav.addObject("id", modelId);
		mav.addObject("action", "/"+modelViewName + "/update");
		mav.setViewName(modelViewName + "/input");
		return mav;
	}
	
	@GetMapping("/user/add")
	public String add() {
		return hello.add("add123456");
	}
	
	@GetMapping("/user/delete")
	public String delete() {
		return hello.delete("add654321");
	}
	
	@GetMapping("/user/throwException")
	public String throwException() {
		return hello.throwException("error");
	}
}
