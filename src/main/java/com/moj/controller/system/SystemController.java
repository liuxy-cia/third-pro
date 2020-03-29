package com.moj.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {
    //跳转中心

    //登录界面跳转
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/aside")
    public String aside(){
        return "aside";
    }

    @RequestMapping("/collection")
    public String collection(){
        return "collection";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/forget/forgetPassword")
    public String forgetPassword(){
        return  "forget/forgetPassword";
    }

    @RequestMapping("/forget/forgetPassword2")
    public String forgetPassword2(){
        return  "forget/forgetPassword2";
    }

    @RequestMapping("/forget/forgetPassword3")
    public String forgetPassword3(){
        return  "forget/forgetPassword3";
    }

    @RequestMapping("/registered/register")
    public String register(){
        return  "/registered/register";
    }

    @RequestMapping("/registered/register2")
    public String register2(){
        return  "/registered/register2";
    }

    @RequestMapping("/registered/register3")
    public String register3(){
        return  "/registered/register3";
    }


}
