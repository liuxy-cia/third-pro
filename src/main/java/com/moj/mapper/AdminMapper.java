package com.moj.mapper;

import com.moj.entity.Admininformation;
import com.moj.entity.CriticReport;
import com.moj.entity.Userinformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangshen  on 2020/3/23 0:59
 */
@Mapper
@Repository
public interface AdminMapper {
    public Admininformation findByName(@Param("name") String name);
    public List<Userinformation> selectUserInformation(@Param("start") String start, @Param("end") String end);
    public List<Userinformation> selectUserInformationbyId(int id);
    public List<Userinformation> selectUserInformationbyname(String name);
    public List<Userinformation> selectUserInformationbyphone(String phone);
    //查询条数
   // public int selectCount();

        //查询处理
    public List<CriticReport> find();
}
