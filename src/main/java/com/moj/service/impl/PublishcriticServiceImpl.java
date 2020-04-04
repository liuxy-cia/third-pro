package com.moj.service.impl;

import com.moj.entity.Publishcritic;
import com.moj.mapper.PublishcriticMapper;
import com.moj.service.PublishcriticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zzz on 2020/4/4 14:08
 */
@Service
public class PublishcriticServiceImpl implements PublishcriticService {
    @Autowired
    private PublishcriticMapper  publishcritic;
    @Override
    public List<Publishcritic> selectPub() {
        return publishcritic.selectPub();
    }
}
