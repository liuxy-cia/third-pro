package com.moj.service;

import com.moj.entity.Userinformation;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zzz on 2020/3/26 11:06
 */
public interface UserinformationService {
    public Userinformation selectUserinformation(String phone);

}
