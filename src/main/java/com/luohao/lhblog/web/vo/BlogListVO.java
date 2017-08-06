package com.luohao.lhblog.web.vo;

import com.luohao.lhblog.biz.domain.BlogDomain;

import java.util.List;

/**
 * Created by luohao on 2017/8/6.
 */
public class BlogListVO extends BasicVO {
    private List<BlogDomain> blogs;

    public List<BlogDomain> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogDomain> blogs) {
        this.blogs = blogs;
    }
}
