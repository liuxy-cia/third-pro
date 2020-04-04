package com.moj.service;

import com.moj.entity.Adminaction;
import com.moj.entity.Admininformation;
import com.moj.entity.Userinformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangshen  on 2020/3/23 1:07
 */

public interface AdminService {
    public Admininformation findByName(String name);
    public List<Userinformation> selectUserInformation(String start, String end);
   // public int selectCount();
    public List<Userinformation> selectUserInformationbyId(int id);
    public List<Userinformation> selectUserInformationbyname(String name);
    public List<Userinformation> selectUserInformationbyphone(String phone);
    public int insert(@Param("adminaction") Adminaction adminaction);
}
