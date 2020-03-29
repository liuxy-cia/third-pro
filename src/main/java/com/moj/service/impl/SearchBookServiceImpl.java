package com.moj.service.impl;

import com.moj.entity.Book;
import com.moj.mapper.BookMapper;
import com.moj.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/27 15:41
 */
@Service
public class SearchBookServiceImpl implements SearchBookService {
    private static final String URL = "https://api.douban.com/v2/book/search?";//豆瓣地址
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private BookMapper bookMapper;

    //在缓存中查找书籍信息
    @Override
    public List<Book> searchBookByName(String name) {
        RedisSerializer redisSerializer1 = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer1);
        List<Book> list = (List<Book>)redisTemplate.opsForValue().get("allBook");
        List<Book> bookList = new ArrayList<Book>();
        if(list != null){
            for (Book book:list) {
                if(book.getTitle().equals(name)){
                    bookList.add(book);
                }
            }
        }else{
            bookList = bookMapper.findByTit(name);
        }

        return bookList;
    }

    @Override
    public List<Book> randBook() {
        return null;
    }

    @Override
    public Book findById(String id) {
        return null;
    }
}
