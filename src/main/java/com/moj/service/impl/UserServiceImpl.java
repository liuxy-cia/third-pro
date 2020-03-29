package com.moj.service.impl;

import com.moj.entity.Userlogin;
import com.moj.mapper.UserMapper;
import com.moj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangshen  on 2020/3/22 20:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    public Userlogin findByAccount(String username) {
        return userMapper.findByAccount(username);
    }
}
