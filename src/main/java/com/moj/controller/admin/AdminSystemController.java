package com.moj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangshen  on 2020/3/23 1:17
 */
@Controller
@RequestMapping("/system/admin")
public class AdminSystemController {
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }
}
