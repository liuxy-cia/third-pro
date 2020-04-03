package com.moj.entity;

import java.io.Serializable;
import java.util.Date;

public class CriticReport implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer uid;

    private Date ctime;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    private Publishcritic publishcritic;
    private Userinformation userinformation;

    public Publishcritic getPublishcritic() {
        return publishcritic;
    }

    public void setPublishcritic(Publishcritic publishcritic) {
        this.publishcritic = publishcritic;
    }

    public Userinformation getUserinformation() {
        return userinformation;
    }

    public void setUserinformation(Userinformation userinformation) {
        this.userinformation = userinformation;
    }
}