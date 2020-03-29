package com.moj.entity;

import java.util.Date;

public class Movieforum {
    private Integer id;

    private Date time;

    private String title;

    private Integer uid;

    private Date modified;

    private Short allow;

    private Integer joinnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Short getAllow() {
        return allow;
    }

    public void setAllow(Short allow) {
        this.allow = allow;
    }

    public Integer getJoinnumber() {
        return joinnumber;
    }

    public void setJoinnumber(Integer joinnumber) {
        this.joinnumber = joinnumber;
    }
}