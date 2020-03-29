package com.moj.mapper;

import com.moj.entity.Admininformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangshen  on 2020/3/23 0:59
 */
@Mapper
public interface AdminMapper {
    public Admininformation findByName(@Param("name") String name);
}
