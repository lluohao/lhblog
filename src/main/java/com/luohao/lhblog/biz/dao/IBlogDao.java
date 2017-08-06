package com.luohao.lhblog.biz.dao;

import com.luohao.lhblog.biz.domain.BlogDomain;

/**
 * Created by luohao on 2017/8/5.
 */
public interface IBlogDao {
    void update(BlogDomain blog);
    int add(BlogDomain blog);
    BlogDomain find(int id);
}
