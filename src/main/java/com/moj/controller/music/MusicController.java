package com.moj.controller.music;

import com.moj.entity.Userinformation;
import com.moj.entity.Wangyimusic;
import com.moj.service.impl.MusicServiceImpl;
import com.moj.service.impl.UserinformationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘鑫宇 on 2020/3/30 16:33
 */
@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicServiceImpl musicService;

    /*@RequestMapping("/allMusic")
    public String showAllMusic(Model model){
        model.addAttribute("result",musicService.showAllMusic().toString());

        return "music/hot";
    }*/
    @RequestMapping(value = "/hot/{type}")
    public String hot(@PathVariable("type") String type, HttpServletRequest request, Model model){
        Userinformation userInformation = (Userinformation) request.getSession().getAttribute("userInformation");
        if (userInformation.getPhone().isEmpty()) {
            return "login";
        }
        List<Wangyimusic> list = new ArrayList<>();
        String title = null;
        switch (type) {
            case "1":
                //云音乐热歌榜-1
                list =  musicService.showAllHot();
                title = "音乐热歌榜";
                break;
            case "2" ://云音乐飙升榜-2
                list = musicService.showAllUp();
                title = "音乐飙升榜";
                break;
            default: //云音乐新歌榜-3
                list =  musicService.showAllNew();
                title = "音乐新歌榜";
                break;
        }
        model.addAttribute("entity", list);
        //model.addAttribute("myFriends", userController.getMyFriends(userInformation.getId()));
        model.addAttribute("userInformation", userInformation);
        model.addAttribute("username", userInformation.getName());
        model.addAttribute("autograph", userInformation.getAutograph());
        model.addAttribute("action", 6);
        model.addAttribute("title", title);
        //userController.getUserCounts(model, userInformation.getId());
        return "music/hot";
    }

    //音乐详情
    @RequestMapping(value = "/information/{id}")
    public String information(@PathVariable("id")String id ,HttpServletRequest request, Model model){
        Userinformation userInformation = (Userinformation) request.getSession().getAttribute("userInformation");
        if (userInformation.getPhone().isEmpty()) {
            return "login";
        }
        //返回结果
       // Wangyimusic informationEntity = new Wangyimusic();
        int ids = Integer.parseInt(id);
        Wangyimusic showMusicInformation = musicService.showMusicInformation(ids);
       /*
            //获取歌手,可能有多个
            String singerIds = wangyimusicEntity.getSingerid();
            informationEntity.setSinger(WangYiSingerService.getSingers(singerIds));
            informationEntity.setPublishTime(Time.DAY.format(wangyialbumEntity.getPublishtime()));
            informationEntity.setSongName(wangyimusicEntity.getName());
            String lyric = service.getMusicLyric(songId);
            if (Tool.getInstance().isNotNull(lyric)) {
                lyric = lyric.replaceAll("\n", "<br/>");
                lyric = lyric.replaceAll("\\[[0-9]+:[0-9]+\\.[0-9]+\\]","");
            }
            informationEntity.setLyric(lyric);
            informationEntity.setPic(wangyimusicEntity.getPicurl());
            if (Tool.getInstance().isNotNull(entity) && Tool.getInstance().isNotNull(entity.getData())) {
                informationEntity.setComments(entity.getData().getHotComments());
            } else {
                informationEntity.setComments(new ArrayList<>());
            }
            informationEntity.setUrl(wangyimusicEntity.getUrl());
        }*/
        model.addAttribute("entity", showMusicInformation);
        //model.addAttribute("myFriends", userController.getMyFriends(userInformation.getId()));
        model.addAttribute("userInformation", userInformation);
        model.addAttribute("username", userInformation.getName());
        model.addAttribute("autograph", userInformation.getAutograph());
        model.addAttribute("action", 6);
        //userController.getUserCounts(model, userInformation.getId());
        return "music/information";
    }

}
