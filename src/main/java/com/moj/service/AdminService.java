package com.moj.service;

import com.moj.entity.Admininformation;

/**
 * Created by yangshen  on 2020/3/23 1:07
 */
public interface AdminService {
    public Admininformation findByName(String name);
}
