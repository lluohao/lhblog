package com.luohao.lhblog.test;

import com.luohao.lhblog.biz.dao.IBlogDao;
import com.luohao.lhblog.biz.domain.BlogDomain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Timestamp;

/**
 * Created by llhao on 2017/8/5.
 */
public class BlogDaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IBlogDao dao = (IBlogDao)context.getBean("blogDao");
        BlogDomain blogDomain = new BlogDomain();
        blogDomain.setMd("md");
        blogDomain.setHtml("<p>md</p>");
        blogDomain.setTime(new Timestamp(System.currentTimeMillis()));
        blogDomain.setTitle("Test");
        blogDomain.setType(0);
        System.out.println("----测试push-----");
        dao.add(blogDomain);
    }
}
