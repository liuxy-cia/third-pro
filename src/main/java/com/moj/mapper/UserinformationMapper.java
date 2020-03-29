package com.moj.mapper;

import com.moj.entity.Userinformation;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zzz on 2020/3/26 10:38
 */
public interface UserinformationMapper {
    //查询用户信息
        public Userinformation selectUserinformation(@Param("phone") String phone);
        //修改个人信息
        public int updateByPrimaryKey(Userinformation id);

}
