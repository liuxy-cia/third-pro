package com.moj.mapper;

import com.moj.entity.Moviename;
import org.springframework.stereotype.Repository;

/**
 * Created by 刘鑫宇 on 2020/3/23 16:48
 */
@Repository
public interface MovieNameMapper {
    public Moviename findAll();
}
