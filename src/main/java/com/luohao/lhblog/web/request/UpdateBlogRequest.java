package com.luohao.lhblog.web.request;

/**
 * Created by luohao on 2017/8/5.
 */
public class UpdateBlogRequest {
    private String oper; //操作类型， 可选add，update
    private Integer id;
    private String title;
    private String md;
    private String html;
    private String desc; //留用
    private Integer type;
    private Integer status;

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMd() {
        return md;
    }

    public String getHtml() {
        return html;
    }

    public String getDesc() {
        return desc;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
