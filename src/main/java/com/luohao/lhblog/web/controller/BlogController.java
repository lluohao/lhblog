package com.luohao.lhblog.web.controller;

import com.luohao.lhblog.biz.dao.IBlogDao;
import com.luohao.lhblog.biz.domain.BlogDomain;
import com.luohao.lhblog.web.request.UpdateBlogRequest;
import com.luohao.lhblog.web.vo.BasicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by llhao on 2017/8/5.
 */
@Controller
public class BlogController {
    @Autowired
    private IBlogDao dao;
    @RequestMapping("/update.do")
    public @ResponseBody BasicVO update(UpdateBlogRequest ubr){
        System.out.println(ubr.getMd());
        BlogDomain blogDomain = new BlogDomain();
        blogDomain.setMd(ubr.getMd());
        blogDomain.setHtml("<p>md</p>");
        blogDomain.setTime(new Timestamp(System.currentTimeMillis()));
        blogDomain.setTitle("Test");
        blogDomain.setType(0);
        dao.add(blogDomain);
        return new BasicVO(200, ubr.getMd());
    }
}
