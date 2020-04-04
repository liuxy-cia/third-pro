package com.moj.service;

import com.moj.entity.Adminaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zzz on 2020/4/4 16:40
 */

public interface AdminUserService {
    public int allowed(int id ,int allowed, Adminaction adminaction);

}
