package com.moj.service.impl;

import com.moj.entity.Wangyimusic;
import com.moj.mapper.MusicMapper;
import com.moj.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/30 16:31
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;


    @Override  //显示热歌榜
    public List<Wangyimusic> showAllHot() {

        return musicMapper.showAllHot();
    }

    @Override
    public List<Wangyimusic> showAllUp() {
        return musicMapper.showAllUp();
    }

    @Override
    public List<Wangyimusic> showAllNew() {
        return musicMapper.showAllNew();
    }
}
