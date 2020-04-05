package com.moj.service;

import com.moj.entity.Wangyimusic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/30 16:30
 */
public interface MusicService {

    public List<Wangyimusic> showAllHot();

    public List<Wangyimusic> showAllUp();

    public List<Wangyimusic> showAllNew();

    public Wangyimusic showMusicInformation(int id);

    public List<Wangyimusic> findObscure(String name);

    //public List<Wangyimusic> showAllMusic();

}
