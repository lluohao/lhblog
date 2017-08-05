package com.luohao.lhblog.biz.dao;

import com.luohao.lhblog.biz.domain.BlogDomain;
import com.luohao.lhblog.entity.Blog;

/**
 * Created by luohao on 2017/8/5.
 */
public interface IBlogDao {
    void update(BlogDomain blog);
    int add(BlogDomain blog);
    Blog find(int id);
}
