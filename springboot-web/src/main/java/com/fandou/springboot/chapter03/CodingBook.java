/**   
 * @Title: Book.java 
 * @Package com.fandou.springboot.chapter02 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午9:46:44
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter03;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: Book
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午9:46:44
 * @version V0.0.1
 */
@Component
@ConfigurationProperties(prefix="book")
public class CodingBook {
	private Integer id;
	private String name;
	private String author;
	private Float price;
	protected String version;
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date publicationDate;
	private List<String> tags;
	private String nullString;
	
	private Map<String,String> comments;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Map<String, String> getComments() {
		return comments;
	}
	public void setComments(Map<String, String> comments) {
		this.comments = comments;
	}
	public String getNullString() {
		return nullString;
	}
	public void setNullString(String nullString) {
		this.nullString = nullString;
	}
	
	
}
