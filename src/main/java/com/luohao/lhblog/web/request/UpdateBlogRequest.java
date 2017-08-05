package com.luohao.lhblog.web.request;

/**
 * Created by luohao on 2017/8/5.
 */
public class UpdateBlogRequest {
    private int id;
    private String titile;
    private String md;
    private String html;
    private String desc;

    public int getId() {
        return id;
    }

    public String getTitile() {
        return titile;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitile(String titile) {
        this.titile = titile;
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
}
