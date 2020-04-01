package com.moj.controller.user;

import com.moj.entity.Userinformation;
import com.moj.mapper.UserloginMapper;
import com.moj.service.UserService;
import com.moj.service.UserloginService;
import com.moj.service.impl.UserinformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangshen  on 2020/4/1 23:21
 */
@Controller
public class UserRegisterController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/userRegister")
    public String userRegister(@RequestParam String phone, @RequestParam String username, @RequestParam String password,
                               HttpServletRequest request, Model model){

        model.addAttribute("phone",phone);
        model.addAttribute("password",password);

        userService.register(phone,password,username);
        return "registered/register3";

    }
}
