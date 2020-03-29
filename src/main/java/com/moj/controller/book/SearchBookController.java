package com.moj.controller.book;

import com.moj.entity.Book;
import com.moj.service.impl.SearchBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/27 14:07
 */
@Controller
@RequestMapping("/book")
public class SearchBookController {
    @Autowired
    private SearchBookServiceImpl searchBookService;

    @RequestMapping(value = "/name/{name}")
    public List<Book> searchByName(@PathVariable(value = "name") String name) {
        return searchBookService.searchBookByName(name);
    }

   /*  @RequestMapping(value = "/init")
    public List<BookEntity> bookRand(){
        return searchBookService.randBook();*/


}
