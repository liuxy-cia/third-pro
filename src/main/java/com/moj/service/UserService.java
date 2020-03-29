package com.moj.service;

import com.moj.entity.Userlogin;

/**
 * Created by yangshen  on 2020/3/22 20:53
 */
public interface UserService {
    public Userlogin findByAccount(String username);
}
