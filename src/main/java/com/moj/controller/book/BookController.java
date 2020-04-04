package com.moj.controller.book;

import com.moj.controller.user.UserLoginController;
import com.moj.entity.Book;
import com.moj.entity.Myfriends;
import com.moj.entity.Userinformation;
import com.moj.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/23 15:11
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private UserLoginController userLoginController;
   /* @Autowired
    private MovieNameMapper movieNameMapper;*/

    // 初始化图书信息
    @RequestMapping("/init")
    public String bookInit(HttpServletRequest request, Model model){
        Userinformation userInformation = (Userinformation) request.getSession().getAttribute("userInformation");
        List<Book> entities = bookService.findAllBook();
        /*for (Book entity : entities) {
            entity.setTranslator(entity.getTranslator().replace("[\"", "").replace("\"]", "").replace("\"", ""));
            entity.setAuthor(entity.getAuthor().replace("[\"", "").replace("\"]", "").replace("\"", ""));
        }*/
       /* model.addObject("entity",entities);
        model.setViewName();*/
        Myfriends myfriends = new Myfriends();
        model.addAttribute("entity", entities);
        model.addAttribute("myFriends", myfriends);
        model.addAttribute("userInformation", userInformation);
        model.addAttribute("username", userInformation.getName());
        model.addAttribute("autograph", userInformation.getAutograph());
        model.addAttribute("action", 7);
       // userController.getUserCounts(model, userInformation.getId());

        return "book/init";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",bookService.findAllBook());
        modelAndView.setViewName("book/book_information");
        return modelAndView;
        //return movieNameMapper.findAll().toString();
    }

    //图书详情
    @RequestMapping(value = "/book_information/{bookId}")
    public String bookInformation(@PathVariable("bookId") long bookId, HttpServletRequest request, Model model) {
        Userinformation userInformation = (Userinformation) request.getSession().getAttribute("userInformation");
        String id = Long.toString(bookId);
        Book entity = bookService.lookForIn(id);
        if (null == entity) {
            model.addAttribute("result", "fail");
            entity = new Book();
        } else {
            model.addAttribute("result", "success");
            entity.setTranslator(entity.getTranslator().replace("[\"", "").replace("\"]", "").replace("\"", ""));
            entity.setAuthor(entity.getAuthor().replace("[\"", "").replace("\"]", "").replace("\"", ""));
            entity.setSummary(entity.getSummary().replace("\n","<br/>"));
            entity.setCatalog(entity.getCatalog().replace("\n", "<br/>"));
            entity.setAuthorIntro(entity.getAuthorIntro().replace("\n","<br/>"));
        }
        model.addAttribute("entity", entity);
       // model.addAttribute("myFriends",);
        model.addAttribute("userInformation", userInformation);
        model.addAttribute("username", userInformation.getName());
        model.addAttribute("autograph", userInformation.getAutograph());
        model.addAttribute("action", 7);
        //userController.getUserCounts(model, userInformation.getId());

        return "book/book_information";
    }
}
