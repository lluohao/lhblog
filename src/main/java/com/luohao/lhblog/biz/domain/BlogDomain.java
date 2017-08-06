package com.luohao.lhblog.biz.domain;

import java.sql.Timestamp;

/**
 * Created by ll=uohao on 2017/8/5.
 * 对应数据库blog表
 */
public class BlogDomain {

    private Integer id;         //主键id
    private String md;      //md源码
    private String html;    //html源码
    private Timestamp time; //创建时间
    private Integer count;      //访问量
    private String title;   //标题
    private Integer type;       //分类，将指向一个Typedef类，但是数据库中并没有添加对应的外键约束
    private Integer status;     //状态 0:草稿 32:公开 64:私密 128:垃圾箱

    public static final Integer STATUS_DRAFT = 0;
    public static final Integer STATUS_PUBLIC = 32;
    public static final Integer STATUS_PRIVATE = 64;
    public static final Integer STATUS_DELETE = 128;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
