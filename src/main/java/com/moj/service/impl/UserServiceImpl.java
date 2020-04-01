package com.moj.service.impl;

import com.moj.entity.Userinformation;
import com.moj.entity.Userlogin;
import com.moj.mapper.UserMapper;
import com.moj.mapper.UserinformationMapper;
import com.moj.mapper.UserloginMapper;
import com.moj.service.UserService;
import com.moj.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by yangshen  on 2020/3/22 20:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserloginMapper userloginMapper;
    @Autowired
    private UserinformationMapper userinformationMapper;


    public Userlogin findByAccount(String username) {
        return userMapper.findByAccount(username);
    }
    public Userinformation findById(int id) {
        return userMapper.findById(id);
    }
    public int updatePwd(Userlogin userlogin){
        return userMapper.updatePwd(userlogin);
    }

    @Transactional
    public void register(String account, String password,String username) {
        userloginMapper.addUser(account,password);
        userinformationMapper.addUserInfo(account,username,new Date());
    }

}
