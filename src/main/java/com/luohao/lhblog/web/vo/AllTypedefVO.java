package com.luohao.lhblog.web.vo;

import com.luohao.lhblog.biz.domain.TypedefDomain;
import java.util.List;

/**
 * Created by llhao on 2017/8/7.
 */
public class AllTypedefVO extends BasicVO {
    private List<TypedefDomain> types;

    public List<TypedefDomain> getTypes() {
        return types;
    }

    public void setTypes(List<TypedefDomain> types) {
        this.types = types;
    }
}
