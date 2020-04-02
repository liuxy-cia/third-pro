package com.moj.mapper;

import com.moj.entity.Wangyimusic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/30 14:52
 */
@Repository
public interface MusicMapper {

    public List<Wangyimusic> showAllHot();

    public List<Wangyimusic> showAllUp();

    public List<Wangyimusic> showAllNew();

    public Wangyimusic showMusicInformation(@Param("id")int id);

}
