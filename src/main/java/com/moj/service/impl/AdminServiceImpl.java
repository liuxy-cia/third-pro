package com.moj.service.impl;

import com.moj.entity.Admininformation;
import com.moj.entity.Userinformation;
import com.moj.mapper.AdminMapper;
import com.moj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangshen  on 2020/3/23 1:11
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admininformation findByName(String name) {
        return adminMapper.findByName(name);
    }

    @Override
    public List<Userinformation> selectUserInformation(String start, String end) {
        return adminMapper.selectUserInformation(start,end);
    }

   /* @Override
    public int selectCount() {
        return adminMapper.selectCount();
    }*/

    @Override
    public List<Userinformation> selectUserInformationbyId(int id) {
        return adminMapper.selectUserInformationbyId(id);
    }

    @Override
    public List<Userinformation> selectUserInformationbyname(String name) {
        return adminMapper.selectUserInformationbyname(name);
    }

    @Override
    public List<Userinformation> selectUserInformationbyphone(String phone) {
        return adminMapper.selectUserInformationbyphone(phone);
    }


}
