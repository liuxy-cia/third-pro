package com.moj.mapper;

import com.moj.entity.Userinformation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by zzz on 2020/3/26 10:38
 */
public interface UserinformationMapper {
    //查询用户信息
        public Userinformation selectUserinformation(@Param("phone") String phone);
        //修改个人信息
        public int updateByPrimaryKey(int id, String address, String autograph, Date birtday, String name, String tel, String sex, String introduction, String city);

    //添加用户信息
        public int addUserInfo(@Param("phone")String phone, @Param("name")String name, @Param("buildtime")Date buildtime);
   //修改(禁用)个人状态
   public int updateUser(@Param("id") int id ,@Param("allowed") int allowed);
}
