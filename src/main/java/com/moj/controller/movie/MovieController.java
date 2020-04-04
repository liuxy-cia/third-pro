package com.moj.controller.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 刘鑫宇 on 2020/4/2 19:43
 */
@Controller
@RequestMapping("/movie")
public class MovieController {


    @RequestMapping("/allMovie")
    public String index(){
        
        return null;
    }

}
