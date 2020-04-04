package com.moj.service.impl;

import com.moj.entity.Userinformation;
import com.moj.mapper.UserinformationMapper;
import com.moj.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zzz on 2020/3/26 11:00
 */
@Service
public class UserinformationImpl implements UserinformationService {
@Autowired
private UserinformationMapper userinformation;
    @Override
    public Userinformation selectUserinformation(String phone) {
        return userinformation.selectUserinformation(phone);
    }
    public int updateByPrimaryKey(int id, String address, String autograph, Date birtday, String name, String tel, String sex, String introduction, String city) {
        return userinformation.updateByPrimaryKey(id,address,autograph,birtday,name,tel,sex,introduction,city);
    }

    @Override
    public int updateUser(int id, int allowed) {
        return userinformation.updateUser(id, allowed);
    }

}
