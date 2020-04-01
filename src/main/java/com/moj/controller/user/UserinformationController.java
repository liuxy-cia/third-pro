package com.moj.controller.user;

import com.moj.entity.Userinformation;
import com.moj.service.impl.UserinformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zzz on 2020/3/27 18:42
 */

@Controller
@RequestMapping("/setting")
public class UserinformationController {
    @Autowired
    private UserinformationImpl userinformation1;
    @RequestMapping("/accountSettings")
    public String selectUserinformation(Model model,String phone){
        Userinformation userinformation = this.userinformation1.selectUserinformation(phone);
        System.out.println(userinformation.getAddress());

         model.addAttribute("userInformation", userinformation);
       return "setting/AccountSettings";
    }
    //修改信息
    @RequestMapping("/modified")
    public String update(@RequestParam(required = false) String userid,@RequestParam(required = false) String autograph,@RequestParam(required = false) String address,@RequestParam(required = false) String name, @RequestParam(required = false) String tel,
                         @RequestParam(required = false) String sex, @RequestParam(required = false) String birth,
                         @RequestParam(required = false) String introduction, @RequestParam(required = false) String city,@RequestParam(required = false) Date birtday,
                         HttpServletRequest request,Model model){
        //userinformation userInformation =(userinformation)request.getSession().getAttribute("userinformation");
       // String account = (String)request.getSession().getAttribute("account");
       int id =(Integer.parseInt(userid)) ;

        System.out.println(id);
        int i = userinformation1.updateByPrimaryKey(id,address,autograph,birtday,name,tel,sex,introduction,city);
        System.out.println(id);
        model.addAttribute(i);

        return "setting/AccountSettings";
    }
}
