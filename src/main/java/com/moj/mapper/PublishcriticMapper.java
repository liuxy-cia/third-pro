package com.moj.mapper;

import com.moj.entity.Publishcritic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zzz on 2020/4/4 13:43
 */
@Mapper
@Repository
public interface PublishcriticMapper {
    public List<Publishcritic> selectPub();
}
