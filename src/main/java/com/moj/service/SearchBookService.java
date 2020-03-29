package com.moj.service;

import com.moj.entity.Book;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/27 15:05
 */
public interface SearchBookService {

    List<Book> searchBookByName(String name);

    List<Book> randBook();

    Book findById(String id);

}
