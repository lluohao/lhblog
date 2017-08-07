package com.luohao.lhblog.web.controller;

import com.luohao.lhblog.biz.domain.TypedefDomain;
import com.luohao.lhblog.biz.service.ITypedefService;
import com.luohao.lhblog.web.vo.AllTypedefVO;
import com.luohao.lhblog.web.vo.BasicVO;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luohao on 2017/8/7.
 */
@Controller
public class TypedefController {
    private static Logger logger = LogManager.getLogger(TypedefController.class);
    @Autowired
    private ITypedefService service;
    @RequestMapping("/typedef/add.do")
    public @ResponseBody BasicVO addTypedef(String tname){
        try {
            return service.addTypedef(tname);
        }catch (Exception e){
            logger.error(e);
            return new BasicVO(500, "添加失败，服务器未知异常！");
        }
    }

    @RequestMapping("/typedef/rename.do")
    public @ResponseBody BasicVO rename(int tid, String tname){
        try {
            return service.rename(tid, tname);
        }catch (Exception e){
            logger.error(e);
            return new BasicVO(500, "修改失败，服务器未知异常！");
        }
    }

    @RequestMapping("/typedef/delete.do")
    public @ResponseBody BasicVO delete(int tid){
        try {
            return service.delete(tid);
        }catch (Exception e){
            logger.error(e);
            return new BasicVO(500, "删除失败，服务器未知异常！");
        }
    }

    @RequestMapping("/typedef/all.do")
    public @ResponseBody BasicVO all(){
        try {
            List<TypedefDomain> typedefDomains = service.allTypedef();
            AllTypedefVO vo = new AllTypedefVO();
            vo.setCode(200);
            vo.setMessage("success");
            vo.setTypes(typedefDomains);
            return vo;
        }catch (Exception e){
            logger.error(e);
            return new BasicVO(500, "获取失败，服务器未知异常！");
        }
    }

}
