package com.moj.service.impl;

import com.moj.entity.Book;
import com.moj.mapper.BookMapper;
import com.moj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/23 15:05
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    /*@Autowired
    private MovieNameMapper movieNameMapper;*/
    @Override
    public List<Book> findAllBook() {
        RedisSerializer redisSerializer1 = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer1);
        List<Book> list = (List<Book>)redisTemplate.opsForValue().get("allBook");
        if(null == list){
            synchronized (this){
                list = (List<Book>)redisTemplate.opsForValue().get("allBook");
                if(null == list){
                    list = bookMapper.findAllBook();
                    redisTemplate.opsForValue().set("allBook",list);
                }
            }
        }else{
            System.out.println("redis缓存");
        }
        return list;
    }

    @Override
    public List<Book> findByTit(String title) {
        return bookMapper.findByTit(title);
    }

    @Override
    public List<Book> findByAut(String author) {
        return bookMapper.findByAut(author);
    }

    @Override
    public Book lookForIn(String bookId) {
        return bookMapper.lookForIn(bookId);
    }

}
