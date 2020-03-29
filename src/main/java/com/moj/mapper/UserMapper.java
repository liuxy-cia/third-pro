package com.moj.mapper;

import com.moj.entity.Userlogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangshen  on 2020/3/22 20:46
 */
@Mapper
public interface UserMapper {
    public Userlogin findByAccount(@Param("username") String username);
}
