package com.luohao.lhblog.web.controller;

import com.luohao.lhblog.web.request.UpdateBlogRequest;
import com.luohao.lhblog.web.vo.BasicVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by llhao on 2017/8/5.
 */
@Controller
public class BlogController {
    @RequestMapping("/update.do")
    public @ResponseBody BasicVO update(UpdateBlogRequest ubr){
        System.out.println(ubr.getMd());
        return new BasicVO(200, ubr.getMd());
    }
}
