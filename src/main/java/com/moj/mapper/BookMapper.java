package com.moj.mapper;

import com.moj.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/23 14:32
 */
@Repository
public interface BookMapper {

    //图书版块展示所有的图书
    public List<Book> findAllBook();
    //根据输入书名模糊查询
    public List<Book> findByTit(@Param("title") String title);
    //根据输入的作者名字模糊查询
    public List<Book> findByAut(@Param("author") String author);
    //点击书籍查询详情  id
    public Book lookForIn(@Param("bookId") String bookId);
}
