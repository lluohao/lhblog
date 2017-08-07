package com.luohao.lhblog.web.controller;

import com.luohao.lhblog.biz.service.IBlogService;
import com.luohao.lhblog.biz.service.exception.IllegalRequestException;
import com.luohao.lhblog.web.request.UpdateBlogRequest;
import com.luohao.lhblog.web.vo.BasicVO;
import com.luohao.lhblog.web.vo.UpdateBlogVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by llhao on 2017/8/5.
 */
@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    private static Logger logger = LogManager.getLogger(BlogController.class);
    @RequestMapping("/update.do")
    public @ResponseBody BasicVO update(@RequestBody UpdateBlogRequest ubr){
        try{
            return service.updateOrSave(ubr);
        }catch (IllegalRequestException e){
            return logAndCreateErrorBasicVO(e);
        }
    }

    @RequestMapping("/list.do")
    public @ResponseBody BasicVO blogList(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int count){
        try {
            return service.simpleBlogs(page, count);
        }catch (IllegalRequestException e){
            return logAndCreateErrorBasicVO(e);
        }
    }

    private BasicVO logAndCreateErrorBasicVO(IllegalRequestException e){
        logger.error("%p %d{yyyy-MM-hh dd:mm:ss} {}", e.getMessage());
        UpdateBlogVO vo = new UpdateBlogVO();
        vo.setMessage(e.getMessage());
        vo.setCode(500);
        return vo;
    }
}
