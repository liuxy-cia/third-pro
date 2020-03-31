package com.moj.service;

import com.moj.entity.Userinformation;
import com.moj.entity.Userlogin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangshen  on 2020/3/22 20:53
 */
public interface UserService {
    public Userlogin findByAccount(String username);
    public Userinformation findById(int id);
    public int updatePwd(Userlogin userlogin);
}
