/**   
 * @Title: BookMapper.java 
 * @Package com.fandou.springboot.chapter05.model.mapper 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:08:28
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fandou.springboot.chapter05.model.Book;

/**
 * @Title: BookMapper
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:08:28
 * @version V0.0.1
 */
@Mapper
public interface BookMapper {
	int addBook(Book book);
	int deleteBook(Integer id);
	int updateBook(Book book);
	Book selectBook(Integer id);
	List<Book> selectAllBook();
}
