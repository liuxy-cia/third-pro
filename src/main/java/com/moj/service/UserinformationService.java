package com.moj.service;

import com.moj.entity.Userinformation;

import java.util.Date;

/**
 * Created by zzz on 2020/3/26 11:06
 */
public interface UserinformationService {
    public Userinformation selectUserinformation(String phone);
    //修改个人信息
    public int updateByPrimaryKey(int id, String address, String autograph, Date birtday, String name, String tel, String sex, String introduction, String city);

}
