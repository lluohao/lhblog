package com.luohao.lhblog.biz.que;

/**
 * Created by luohao on 2017/8/6.
 * 分页查询器
 */
public class PageQuerier {
    private Integer from;//从第几条数据开始查询
    private Integer count;//查询几条

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
