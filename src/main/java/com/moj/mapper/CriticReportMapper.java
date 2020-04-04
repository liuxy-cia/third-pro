package com.moj.mapper;

import com.moj.entity.CriticReport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zzz on 2020/4/3 15:53
 */
@Mapper
@Repository
public interface CriticReportMapper {
    //查询处理
    public List<CriticReport> find();
    //
}
