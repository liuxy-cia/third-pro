package com.moj.controller.sendCode.entity;

/**
 * Created by yangshen  on 2020/3/30 15:37
 */
public class CodeResult {
    String code;
    String msg;
    int status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public CodeResult(String code, String msg, int status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }
    public CodeResult(){}
}
