package com.moj.service.impl;

import com.moj.entity.Wangyimusic;
import com.moj.mapper.MusicMapper;
import com.moj.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/30 16:31
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

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

    @Override
    public Wangyimusic showMusicInformation(int id) {
        return musicMapper.showMusicInformation(id);
    }

    @Override
    public  List<Wangyimusic> findObscure(String name) {
        RedisSerializer redisSerializer1 = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer1);
        List<Wangyimusic> list = (List<Wangyimusic>)redisTemplate.opsForValue().get("allMusic");
        if(null == list){
            synchronized (this){
                list = (List<Wangyimusic>)redisTemplate.opsForValue().get("allMusic");
                if(null == list){
                    System.out.println("查询mysql数据库");
                    list = musicMapper.showAllMusic();
                    redisTemplate.opsForValue().set("allMusic",list);
                }else{
                    System.out.println("redis缓存");
                }
            }
        }else{
            System.out.println("redis缓存");
        }
        List<Wangyimusic> list1 = new ArrayList<>();
        list1 = musicMapper.findObscure(name);
        return list1;
    }
}
