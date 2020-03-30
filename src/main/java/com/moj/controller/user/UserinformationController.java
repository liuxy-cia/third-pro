package com.moj.controller.user;

import com.moj.entity.Userinformation;
import com.moj.service.impl.UserinformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(userinformation.getAddress());
         model.addAttribute("userInformation", userinformation);
       return "setting/AccountSettings";

    }

}
