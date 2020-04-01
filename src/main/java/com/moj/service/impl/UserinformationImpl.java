package com.moj.service.impl;

import com.moj.entity.Userinformation;
import com.moj.mapper.UserinformationMapper;
import com.moj.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
