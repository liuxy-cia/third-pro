package com.moj.service.impl;

import com.moj.entity.CriticReport;
import com.moj.mapper.CriticReportMapper;
import com.moj.service.CriticReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zzz on 2020/4/3 16:21
 */
@Service
public class CriticReportServiceImpl implements CriticReportService {
    @Autowired
    private CriticReportMapper criticReportMapper;
    @Override
    public List<CriticReport> find() {
        return criticReportMapper.find();
    }
}
