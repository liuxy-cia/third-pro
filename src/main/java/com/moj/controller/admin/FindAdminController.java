package com.moj.controller.admin;

import com.moj.entity.*;
import com.moj.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class FindAdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CriticReportService criticReportService;
    @Autowired
    private PublishcriticService publishcriticService;
    @Autowired
    private UserinformationService userinformationService;
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }
    @RequestMapping("/index")
    public String login(@RequestParam String username, @RequestParam String password,
                        Model model, HttpServletRequest request){
        System.out.println(123);
        String name = (String)request.getSession().getAttribute("username");
        model.addAttribute("name",name);
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
        request.getSession().setAttribute("adminInformation", admin);
        model.addAttribute("name", admin.getName());
        return "admin/index";
    }
    @RequestMapping(value = "/findAllUser")
    public String findAll(@RequestParam(required = false) String start, @RequestParam(required = false) String end,
                          Model model, HttpServletRequest request) {

        int s, e;
            if (start==null || start.equals("")) {
                s = 0;
            } else {
                s = Integer.parseInt(start);
            }
            if (end==null || end.equals("")) {
                e = 0;
            } else {
                e = Integer.parseInt(end);
            }
            Admininformation entity = (Admininformation) request.getSession().getAttribute("adminInformation");
            if (start==null || start.equals("")) {
                return "admin/login";
            }
            List<Userinformation> entities = this.adminService.selectUserInformation(start,end);
            model.addAttribute("entity", entities);
//        model.addAttribute("name", entity.getName());
            return "admin/all_user";
        }
    @RequestMapping(value = "/findUser")
    public String findUser(@RequestParam(required = false) String start, @RequestParam(required = false) String end,@RequestParam String id, @RequestParam String username, @RequestParam String phone,
                           Model model, HttpServletRequest request) {
        Admininformation entity = (Admininformation) request.getSession().getAttribute("adminInformation");

        if (entity==null || entity.equals("")) {
            return "admin/login";
        }
        List<Userinformation> entities;
        if (id!=null) {
            entities = adminService.selectUserInformationbyId(Integer.parseInt(id));
        } else if (username!=null) {
            entities = adminService.selectUserInformationbyname(username);
        } else if (phone!=null) {
            entities =adminService.selectUserInformationbyphone(phone);
        } else {
            entities = adminService.selectUserInformation(start,end);
        }
        model.addAttribute("entity", entities);
        return "admin/all_user";
    }
    //处理举报
    @RequestMapping("/findAllReport")
    public String findReport(Model model, HttpServletRequest request) {
        Admininformation entity = (Admininformation) request.getSession().getAttribute("adminInformation");
        if (entity==null || entity.equals("")) {
            return "admin/login";
        }
        List<CriticReport> entities = criticReportService.find();
        for (CriticReport re : entities) {
            if (re.getPublishcritic().getPicture()!=null && !re.getPublishcritic().getPicture().startsWith("/")) {
                re.getPublishcritic().setPicture("/" + re.getPublishcritic().getPicture());
            }
            System.out.println(re.getUserinformation().getPhone());
            System.out.println(re.getPublishcritic().getCritic());

            System.out.println(11);
        }
        model.addAttribute("entity", entities);
        return "admin/all_report";
    }
    @RequestMapping( "/findAllCritic")
    public String findCritic(Model model, HttpServletRequest request) {
        Admininformation entity = (Admininformation) request.getSession().getAttribute("adminInformation");
        if (entity == null || entity.equals("")) {
            return "admin/login";
        }
        List<Publishcritic> entities = publishcriticService.selectPub();
        for (Publishcritic re : entities) {
            if (re.getPicture()!=null && !re.getPicture().startsWith("/")) {
                re.setPicture("/" + re.getPicture());
            }
            System.out.println(re.getUid());
            System.out.println(111);
        }
            model.addAttribute("entity", entities);
            return "admin/all_critic";
        }

    //禁用用户
    @RequestMapping("/changeAllowed")
    public String changeAllowed(@RequestParam(value = "allowed") int allowed, @RequestParam("id") int id, HttpServletRequest request) {
        Admininformation entity = (Admininformation) request.getSession().getAttribute("adminInformation");
        if (entity==null || entity.equals("")) {
            System.out.println("管理员未登录!");
            return "admin/login";
        }
        // int i = userinformationService.updateUser(id, allowed);
        Adminaction adminAction = new Adminaction();
        adminAction.setAction("管理员" + entity.getName() + ":禁用用户:" + id + ",成功");
        adminAction.setAid(entity.getId());
        adminAction.setModified(new Date());
       /* if (i < 1) {
            System.out.println("更新失败!");
            adminAction.setAction("管理员" + entity.getName() + ":禁用用户:" + id + ",失败");
        }*/
        adminUserService.allowed(id,allowed,adminAction);
        return "admin/all_user";
    }
}
