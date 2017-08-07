package com.luohao.lhblog.biz.service.impl;

import com.luohao.lhblog.biz.dao.ITypedefDao;
import com.luohao.lhblog.biz.domain.TypedefDomain;
import com.luohao.lhblog.biz.service.ITypedefService;
import com.luohao.lhblog.common.util.StringUtils;
import com.luohao.lhblog.web.vo.AddTypedefVO;
import com.luohao.lhblog.web.vo.BasicVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luohao on 2017/8/7.
 */
@Service
public class TypedefServiceImpl implements ITypedefService {
    @Autowired
    private ITypedefDao dao;
    @Override
    public BasicVO addTypedef(String name) {
        BasicVO vo = new BasicVO();
        if (StringUtils.isEmpty(name)) {
            vo.setMessage("type name is empty!");
            vo.setCode(400);
            return vo;
        }
        TypedefDomain domain = dao.findByName(name);
        if (domain != null) {
           vo.setMessage("类型：\""+name+"\" 已经存在");
           vo.setCode(400);
           return vo;
        }
        domain = new TypedefDomain();
        domain.setTname(name);
        int flag = dao.add(domain);
        if(flag>0){
            AddTypedefVO avo = new AddTypedefVO();
            avo.setMessage("添加类型成功");
            avo.setCode(200);
            avo.setTid(domain.getTid());
            return avo;
        }else {
            vo.setMessage("添加类型失败！未知错误");
            vo.setCode(300);
            return vo;
        }
    }

    @Override
    public BasicVO delete(int id) {
        int flag = dao.delete(id);
        return new BasicVO(flag>0 ? 200 : 300, flag>0 ? "删除成功！" : "类型不存在！");
    }

    @Override
    public BasicVO rename(int id, String newName) {
        TypedefDomain domain = dao.findById(id);
        if(StringUtils.isEmpty(newName)){
            return new BasicVO(400, "Name is empty!");
        }
        if (domain == null) {
            return new BasicVO(400, "类型不存在");
        }
        if(newName.equals(domain.getTname())){
            return new BasicVO(400, "未做任何更改");
        }
        if(dao.findByName(newName)!=null){
            return new BasicVO(400, "新的类型名称已经存在！");
        }
        domain.setTname(newName);
        int flag = dao.update(domain);
        return new BasicVO(flag>0 ? 200 : 300, flag>0 ? "修改成功！" : "修改失败！未知错误");
    }

    @Override
    public List<TypedefDomain> allTypedef() {
        return dao.allTypedef();
    }
}
