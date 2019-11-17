/**   
 * @Title: HelloController.java 
 * @Package com.fandou.springboot.chapter01.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午8:13:22
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter03;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: HelloController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午8:13:22
 * @version V0.0.1
 */
@RestController
public class CodingBookController {
	/**
	 * @Title: hello 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@GetMapping("/codingbooks")
	public ModelAndView books() {
		List<CodingBook> books = new ArrayList<CodingBook>();
		CodingBook b = new CodingBook();
		b.setId(1);
		b.setAuthor("A1");
		b.setName("C++");
		b.setPrice(30.50f);
		b.setVersion("1.0");
		b.setPublicationDate(new Date());
		books.add(b);
		CodingBook b2 = new CodingBook();
		b2.setId(2);
		b2.setAuthor("A2");
		b2.setVersion("1.0.0");
		b2.setName("Java");
		b2.setPrice(40.50f);
		b2.setPublicationDate(new Date());
		books.add(b2);
		CodingBook b3 = new CodingBook();
		b3.setId(3);
		b3.setAuthor("A3");
		b3.setName("HTML");
		b3.setPrice(22.50f);
		b3.setVersion("2.0");
		b3.setPublicationDate(new Date());
		books.add(b3);
		ModelAndView mv = new ModelAndView();
		mv.addObject("books",books);
		mv.setViewName("books");
		return mv;
	}
	
	@GetMapping("/jsonbooks")
	public List<CodingBook> jsonBooks() {
		List<CodingBook> books = new ArrayList<CodingBook>();
		CodingBook b = new CodingBook();
		b.setId(1);
		b.setAuthor("A1");
		b.setName("C++");
		b.setPrice(30.50f);
		b.setVersion("1.0");
		b.setPublicationDate(new Date());
		books.add(b);
		CodingBook b2 = new CodingBook();
		b2.setId(2);
		b2.setAuthor("A2");
		b2.setVersion("1.0.0");
		b2.setName("Java");
		b2.setPrice(40.50f);
		b2.setPublicationDate(new Date());
		books.add(b2);
		CodingBook b3 = new CodingBook();
		b3.setId(3);
		b3.setAuthor("A3");
		b3.setName("HTML");
		b3.setPrice(22.50f);
		b3.setVersion("2.0");
		b3.setPublicationDate(new Date());
		books.add(b3);
		return books;
	}
	
}
