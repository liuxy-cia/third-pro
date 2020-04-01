package com.moj.controller.sendCode;

import com.alibaba.fastjson.JSON;
import com.moj.controller.sendCode.entity.CodeResult;
import com.moj.entity.Userlogin;
import com.moj.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.CoderMalfunctionError;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by yangshen  on 2020/3/30 14:18
 */
@Controller
public class SendCode {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/sendCode")
    @ResponseBody
    public void ZZY(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String phone = request.getParameter("phone");
        System.out.println(phone);
        String url = "https://sms_developer.zhenzikj.com";
        String appId = "103383";
        String appSe =  "cdd59763-5702-484b-8025-874fa394fb37";
        ZhenziSmsClient client = new ZhenziSmsClient(url, appId,appSe);
        Map<String, String> params = new HashMap<String, String>();
        String num = "1234567890";
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(num.length());
            char c = num.charAt(index);
            code += c;
        }
        request.getSession().setAttribute("code",code);
        String masage = "欢迎进入瓢虫微生活社区找回密码服务，您的验证码为："+code;
        params.put("message",masage);
        params.put("number", phone);
        String result = client.send(params);
        System.out.println(112233);
        int number = 1;
        //判断是否有该用户
        Userlogin user = userMapper.findByAccount(phone);
        if(user==null){
            number = -1;
        }

        PrintWriter writer = response.getWriter();
        CodeResult codeResult = new CodeResult(code,null,number);
        String jsonString = JSON.toJSONString(codeResult);
        writer.print(jsonString);
        writer.flush();
        writer.close();

    }

    @RequestMapping(value = "/eqCode")
    @ResponseBody
    public CodeResult eqCode(HttpServletRequest request){
        String code = request.getParameter("code");
        CodeResult codeResult = new CodeResult();
        Object eqCode =(String) request.getSession().getAttribute("code");
        if(code.equals(eqCode)){
            codeResult.setStatus(1);
        }else{
            codeResult.setStatus(3);
        }
        return codeResult;
    }
    public static String send(HttpServletRequest request,String phone)throws Exception{
        String url = "https://sms_developer.zhenzikj.com";
        String appId = "103383";
        String appSe =  "cdd59763-5702-484b-8025-874fa394fb37";
        ZhenziSmsClient client = new ZhenziSmsClient(url, appId,appSe);
        Map<String, String> params = new HashMap<String, String>();
        String num = "1234567890";
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(num.length());
            char c = num.charAt(index);
            code += c;
        }
        request.getSession().setAttribute("code",code);
        String masage ="欢迎注册瓢虫微生活社区，您的验证码为："+code;;
        params.put("message",masage);
        params.put("number", phone);
        String result = client.send(params);
        return code;
    }
}
