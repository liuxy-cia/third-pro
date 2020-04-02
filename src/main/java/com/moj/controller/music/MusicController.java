package com.moj.controller.music;

import com.moj.entity.Userinformation;
import com.moj.service.impl.MusicServiceImpl;
import com.moj.service.impl.UserinformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 刘鑫宇 on 2020/3/30 16:33
 */
@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicServiceImpl musicService;

    @RequestMapping("/allMusic")
    public String showAllMusic(Model model){
        model.addAttribute("result",musicService.showAllMusic().toString());

        return "music/hot";
    }
    @RequestMapping(value = "/hot/{type}")
    public String hot(@PathVariable("type") String type, HttpServletRequest request, Model model){
        Userinformation userInformation = (Userinformation) request.getSession().getAttribute("userInformation");
        /*if (Tool.getInstance().isNullOrEmpty(userInformation)) {
            return "redirect:/login";
        }*/
        //WangYiResponseEntity entity;
        String title;
        /*switch (type) {
            case "1":
                //云音乐热歌榜-1
                entity = (WangYiResponseEntity) service.getHotMusic();
                title = "音乐热歌榜";
                break;
            case "2" ://云音乐飙升榜-2
                entity = (WangYiResponseEntity) service.getHottingMusic();
                title = "音乐飙升榜";
                break;
            default: //云音乐新歌榜-3
                entity = (WangYiResponseEntity) service.getNewMusic();
                title = "音乐新歌榜";
                break;
        }
        model.addAttribute("entity", entity.getData());
        model.addAttribute("myFriends", userController.getMyFriends(userInformation.getId()));
        model.addAttribute("userInformation", userInformation);
        model.addAttribute("username", userInformation.getName());
        model.addAttribute("autograph", userInformation.getAutograph());
        model.addAttribute("action", 6);
        model.addAttribute("title", title);
        userController.getUserCounts(model, userInformation.getId());*/
        return "music/hot";
    }
}
