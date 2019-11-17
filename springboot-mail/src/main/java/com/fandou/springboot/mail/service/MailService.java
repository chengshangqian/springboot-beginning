/**   
 * @Title: MailService.java 
 * @Package com.fandou.springboot.mail.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午3:15:30
 * @version V0.0.1  
 */
package com.fandou.springboot.mail.service;

import java.io.File;

/**
 * @Title: MailService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午3:15:30
 * @version V0.0.1
 */
public interface MailService {

	/**
	 * @Title: sendSimpleMail 
	 * @Description: 发送简单文本内容的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param cc 抄送
	 */
	void sendSimpleMail(String subject,String content,String from,String to,String cc);
	
	/**
	 * @Title: sendAttachFileMail 
	 * @Description: 发送带附件的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param files 附件列表
	 * @param cc 抄送
	 */
	void sendAttachmentMail(String subject,String content,String from,String to,File[] files,String cc);
	
	/**
	 * @Title: sendRichContentMail 
	 * @Description: 发送带图片的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param resPaths 图片本地路径
	 * @param resIds 图片资源id
	 * @param cc 抄送
	 */
	void sendRichMail(String subject,String content,String from,String to,String[] resPaths,String[] resIds,String cc);
	
	/**
	 * @Title: sendHtmlMail 
	 * @Description: 使用Thymeleaf模板发送html邮件
	 * @param subject 主题
	 * @param template html模板
	 * @param from 发件人
	 * @param to 收件人
	 * @param files 附件列表
	 * @param cc 抄送
	 */
	void sendHtmlMail(String subject,String template,String from,String to,File[] files,String cc);
	
}
