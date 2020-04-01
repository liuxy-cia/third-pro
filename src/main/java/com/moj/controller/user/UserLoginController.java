package com.moj.controller.user;

import com.moj.controller.sendCode.SendCode;
import com.moj.controller.sendCode.entity.CodeResult;
import com.moj.entity.Myfriends;
import com.moj.entity.Userlogin;
import com.moj.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangshen  on 2020/3/23 0:57
 */
@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/home")
    //@ResponseBody
    public String login(@RequestParam String username, @RequestParam String password,
                        Model model, HttpServletRequest request, HttpServletResponse response){
        //ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            model.addAttribute("error", "账号或者密码不能为空");
            //modelAndView.setViewName("login");
            return "login";
        }
        Userlogin user = userService.findByAccount(username);
        if(user == null){
            model.addAttribute("error", "请输入正确的账号！");
            // modelAndView.setViewName("login");
            System.out.println(123);
            return "login";
        }
        if(!password.equals(user.getPassword())){
            model.addAttribute("error", "密码错误！");
            //modelAndView.setViewName("login");
            return "login";
        }
        Myfriends myfriends = new Myfriends();
        //modelAndView.addObject("userInformation", userService.findById(user.getId()));
        model.addAttribute("userInformation", userService.findById(user.getId()));
        model.addAttribute("result",myfriends);
        //modelAndView.setViewName("home");
        //modelAndView.addObject("result",myfriends);
        //把userInformation 存储到session里面，其他页面获取信息
        request.getSession().setAttribute("userInformation",userService.findById(user.getId()));


        return "home";
    }

    @RequestMapping(value = "/modify")
    public String modify(@RequestParam String password,HttpServletRequest request,Model model){
        String phone = (String) request.getSession().getAttribute("phone");
        System.out.println(phone);
        Userlogin userlogin = new Userlogin();
        userlogin.setAccount(phone);
        userlogin.setPassword(password);
        userService.updatePwd(userlogin);
        model.addAttribute("phone",phone);
        model.addAttribute("password",password);
        return "/forget/forgetPassword3";
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public CodeResult register(HttpServletRequest request, Model model)throws Exception{
        String phone = request.getParameter("phone");
        model.addAttribute("phone",phone);
        Userlogin user = userService.findByAccount(phone);
        CodeResult codeResult = new CodeResult();
        if(user!=null){
            codeResult.setStatus(-1);
            codeResult.setCode("");
        }else{

            codeResult.setCode( SendCode.send(request,phone));
            codeResult.setStatus(1);
        }

        return codeResult;
    }
}
