package com.moj.service.impl;

import com.moj.entity.Adminaction;
import com.moj.service.AdminService;
import com.moj.service.AdminUserService;
import com.moj.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zzz on 2020/4/4 16:44
 */
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserinformationService userinformationService;
    @Override
    public int allowed(int id, int allowed, Adminaction adminaction) {
         adminService.insert(adminaction);
        userinformationService.updateUser(id,allowed);

        return 0;
    }
}
