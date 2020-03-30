package com.moj.controller.music;

import com.moj.service.impl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
