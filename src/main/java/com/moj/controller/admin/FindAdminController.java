package com.moj.controller.admin;

import com.moj.entity.Admininformation;
import com.moj.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class FindAdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }
    @RequestMapping("/index")
    public String login(@RequestParam String username, @RequestParam String password,
                        Model model, HttpServletRequest request){
        System.out.println(123);
        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            model.addAttribute("error", "账号或者密码不能为空");
            return "admin/login";
        }
        Admininformation admin = adminService.findByName(username);
        if(admin == null){
            model.addAttribute("error", "请输入正确的账号！");
            return "admin/login";
        }
        if(!password.equals(admin.getPassword())){
            model.addAttribute("error", "密码错误！");
            System.out.println(11111);
            return "admin/login";
        }

        return "admin/index";
    }
}
