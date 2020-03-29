package com.moj.service.impl;

import com.moj.entity.Admininformation;
import com.moj.mapper.AdminMapper;
import com.moj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
