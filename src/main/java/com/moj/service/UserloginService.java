package com.moj.service;

import com.moj.entity.Userlogin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zzz on 2020/3/30 16:13
 */
public interface UserloginService {
    //修改密码
    public Userlogin updatePwd(@Param("account") String account);
}
