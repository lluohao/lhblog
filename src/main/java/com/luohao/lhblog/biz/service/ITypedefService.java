package com.luohao.lhblog.biz.service;

import com.luohao.lhblog.biz.domain.TypedefDomain;
import com.luohao.lhblog.web.vo.BasicVO;
import java.util.List;

/**
 * Created by luohao on 2017/8/7.
 */
public interface ITypedefService {
    BasicVO addTypedef(String name);
    BasicVO rename(int id, String newName);
    List<TypedefDomain> allTypedef();
    BasicVO delete(int id);
}
