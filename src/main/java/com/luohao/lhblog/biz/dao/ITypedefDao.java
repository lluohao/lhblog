package com.luohao.lhblog.biz.dao;

import com.luohao.lhblog.biz.domain.TypedefDomain;
import java.util.List;

/**
 * Created by luohao on 2017/8/7.
 */
public interface ITypedefDao {
    List<TypedefDomain> allTypedef();
    int add(TypedefDomain typedefDomain);
    TypedefDomain findByName(String tname);
    TypedefDomain findById(int tid);
    int delete(int tid);
    int update(TypedefDomain typedefDomain);
}
