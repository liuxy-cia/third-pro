package com.moj.mapper;

import com.moj.entity.Userlogin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zzz on 2020/3/29 16:31
 */
public interface UserloginMapper {
    //修改密码
    public Userlogin updatePwd(@Param("account") String account);

    //注册用户
    public int addUser(@Param("account") String account,@Param("password")String password);
}
