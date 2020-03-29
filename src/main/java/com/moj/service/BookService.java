package com.moj.service;

import com.moj.entity.Book;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/23 15:04
 */
public interface BookService {

    //图书版块展示所有的图书
    public List<Book> findAllBook();

    //根据输入书名模糊查询
    public List<Book> findByTit(String title);

    //根据输入的作者名字模糊查询
    public List<Book> findByAut(String author);

    //查看书籍详情
    public Book lookForIn(String bookId);
}
