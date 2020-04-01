package com.moj.service.impl;

import com.moj.entity.Userlogin;
import com.moj.mapper.UserloginMapper;
import com.moj.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zzz on 2020/3/30 16:14
 */
@Service
public class UserloginServiceImpl implements UserloginService {
    @Autowired
    private UserloginMapper userloginMapper;
    @Override
    public Userlogin updatePwd(String account) {
        return userloginMapper.updatePwd(account);
    }

    @Override
    public int addUser(String account, String password) {
        return userloginMapper.addUser(account,password);
    }
}
