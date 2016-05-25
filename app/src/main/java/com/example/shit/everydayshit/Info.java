package com.example.shit.everydayshit;

/**
 * Created by He on 2016/5/23.
 */

import java.sql.Timestamp;

public class Info {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getInfoclass() {
        return infoclass;
    }

    public void setInfoclass(int infoclass) {
        this.infoclass = infoclass;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Info() {
    }


    public Info(int infoclass, String title, String img, String description, String keywords, String message, int count,
                int fcount, int rcount, Timestamp time) {
        super();
        this.infoclass = infoclass;
        this.title = title;
        this.img = img;
        this.description = description;
        this.keywords = keywords;
        this.message = message;
        this.count = count;
        this.fcount = fcount;
        this.rcount = rcount;
        this.time = time;
    }


    private int infoclass;// 分类
    private String title;// 资讯标题
    private String img;// 图片
    private String description;// 描述
    private String keywords;// 关键字
    private String message;// 资讯内容
    private int count;// 访问次数
    private int fcount;// 收藏数
    private int rcount;// 评论读数
    private Timestamp time;

    @Override
    public String toString() {
        return "Info [infoclass=" + infoclass + ", title=" + title + ", img=" + img + ", description=" + description
                + ", keywords=" + keywords + ", message=" + message + ", count=" + count + ", fcount=" + fcount
                + ", rcount=" + rcount + ", time=" + time + "]";
    }


}
