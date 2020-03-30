package com.moj.controller.user;

import com.moj.entity.Userlogin;
import com.moj.service.impl.UserloginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zzz on 2020/3/30 16:19
 */
@Controller
@RequestMapping("/setting")
public class Userlogin1Controller {
    @Autowired
    private UserloginServiceImpl userloginService;
    @RequestMapping("/Security")
    public String password(Model model, @RequestParam String old_password, @RequestParam String new_password, HttpServletRequest request) {
        String account = (String)request.getSession().getAttribute("account");
        System.out.println(account);
       /* String old_password1 = request.getParameter("old_password");
        String new_password1 = request.getParameter("new_password");*/
        Userlogin userlogin = userloginService.updatePwd(account);
        System.out.println(userlogin.getPassword());
        System.out.println(userlogin.getPassword());
        if(old_password.equals(userlogin.getPassword())){
            if(!old_password.equals(new_password)){
                model.addAttribute("error","成功");
            }else{
                model.addAttribute("error","新密码和旧密码不能相同");
            }
            model.addAttribute("error","旧密码不对");
        }
        return "/setting/Secutity";
    }
}