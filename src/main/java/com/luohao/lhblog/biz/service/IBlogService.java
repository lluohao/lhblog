package com.luohao.lhblog.biz.service;

import com.luohao.lhblog.web.request.UpdateBlogRequest;
import com.luohao.lhblog.web.vo.BlogListVO;
import com.luohao.lhblog.web.vo.UpdateBlogVO;

/**
 * Created by luohao on 2017/8/6.
 */
public interface IBlogService {
    UpdateBlogVO updateOrSave(UpdateBlogRequest blog);
    BlogListVO simpleBlogs(int page, int count);
}
