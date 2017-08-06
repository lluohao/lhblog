package com.luohao.lhblog.biz.service.impl;

import com.luohao.lhblog.biz.dao.IBlogDao;
import com.luohao.lhblog.biz.domain.BlogDomain;
import com.luohao.lhblog.biz.que.PageQuerier;
import com.luohao.lhblog.biz.service.IBlogService;
import com.luohao.lhblog.biz.service.exception.IllegalRequestException;
import com.luohao.lhblog.common.util.StringUtils;
import com.luohao.lhblog.web.request.UpdateBlogRequest;
import com.luohao.lhblog.web.vo.BlogListVO;
import com.luohao.lhblog.web.vo.UpdateBlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by luohao on 2017/8/6.
 */
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogDao dao;
    @Override
    public UpdateBlogVO updateOrSave(UpdateBlogRequest blog) {
        try {
            if (!check(blog)) {
                throw new IllegalRequestException("Illegal request title is empty or type is empty!");
            }
            if ("add".equalsIgnoreCase(blog.getOper())) { //处理添加
                BlogDomain domain = new BlogDomain();
                domain.setType(blog.getType());
                domain.setTitle(blog.getTitle());
                domain.setHtml(blog.getHtml());
                domain.setMd(blog.getMd());
                domain.setStatus(blog.getStatus()==null?0:blog.getStatus());
                domain.setCount(0);
                domain.setTime(new Timestamp(System.currentTimeMillis()));
                int flag = dao.add(domain);
                int id = domain.getId();
                if (flag > 0 && dao.find(id) != null) {
                    UpdateBlogVO vo = new UpdateBlogVO();
                    vo.setBlogId(id);
                    vo.setCode(200);
                    vo.setMessage("添加成功");
                    return vo;
                } else {
                    UpdateBlogVO vo = new UpdateBlogVO();
                    vo.setCode(500);
                    vo.setMessage("添加失败！");
                    return vo;
                }
            } else if ("update".equalsIgnoreCase(blog.getOper())) {    //处理更新
                BlogDomain domain = null;
                if (blog.getId() == null || blog.getId() <= 0 || (domain = dao.find(blog.getId())) == null) {
                    throw new IllegalRequestException("no such blog, please add first, set the oper = 'add'");
                } else {
                    domain.setTitle(blog.getTitle());
                    domain.setHtml(blog.getHtml());
                    domain.setMd(blog.getMd());
                    domain.setType(blog.getType());
                    domain.setStatus(blog.getStatus()==null?0:blog.getStatus());
                    dao.update(domain);
                    UpdateBlogVO vo = new UpdateBlogVO();
                    vo.setBlogId(domain.getId());
                    vo.setCode(200);
                    vo.setMessage("更新成功！");
                    return vo;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            if(e instanceof IllegalRequestException){
                throw e;
            }
            throw new IllegalRequestException("Error! unknow exception!");
        }
        throw new IllegalRequestException("oper must be 'add' or 'update'");
    }

    @Override
    public BlogListVO simpleBlogs(int page, int count) {
        if(page<=0 || count<=0){
            throw new IllegalRequestException("page or count less than zreo !");
        }
        try {
            PageQuerier querier = new PageQuerier();
            querier.setFrom((page-1)*count);
            querier.setCount(count);
            List<BlogDomain> blogDomains = dao.simpleBlogs(querier);
            BlogListVO vo = new BlogListVO();
            vo.setCode(200);
            vo.setMessage("success");
            vo.setBlogs(blogDomains);
            return vo;
        }catch (Exception e){
            e.printStackTrace();
            if(e instanceof IllegalRequestException){
                throw e;
            }
            throw new IllegalRequestException("Error! Unknow exception!");
        }
    }

    private boolean check(UpdateBlogRequest request){
        return StringUtils.notEmpty(request.getTitle()) && request.getType()!=null;
    }
}
