package com.yphone.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yphone.mappers.UserInfoMapper;
import com.yphone.model.nochange.UserInfo;
import com.yphone.service.LoginService;
import com.yphone.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhansen on 2018/5/21.
 */
@Controller

@RequestMapping("/")

public class MainController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    private String code;





    @RequestMapping(value = "/loginProcess",method = RequestMethod.POST)
    public void loginProcess(HttpServletRequest request, HttpServletResponse response)throws IOException{
        //TODO 用户登录，返回数字用字符串形式，如“1”；


        String username=request.getParameter("userID");
        String password=request.getParameter("password");
        int result=loginService.loginResult(username,password);
        String phone;
        if(username.matches("[0-9]{11}")) {
            phone = new String(username);
            username=userInfoMapper.getNameByPhone(phone);
        }
        else{
            phone=userInfoMapper.getPhoneByName(username);
        }

        Writer writer=null;
        response.setCharacterEncoding("UTF-8");
        writer=response.getWriter();
        writer.write(String.valueOf(result));
        if(1==result){
            //创建一个session对象保存信息
            HttpSession session=request.getSession();
            session.setAttribute("userName",username);
            session.setAttribute("phone",phone);

        }
        if(writer!=null){
            writer.flush();
            writer.close();
        }
    }

    @RequestMapping(value = "/registerProcess",method = RequestMethod.POST)
    public void  registerProcess(@ModelAttribute UserInfo userInfo,HttpServletRequest request, HttpServletResponse response)throws IOException{
        //TODO 用户注册
        //String code=request.getParameter("code");
        String thisCode=(String)request.getSession().getAttribute("code");
        Writer writer=null;
        response.setCharacterEncoding("UTF-8");
        writer=response.getWriter();
       int checkResult=loginService.register(userInfo.getPhone(),userInfo.getUserName());
       if(checkResult==2)    //号码已被注册
           writer.write(String.valueOf(checkResult));
       else if(checkResult==3)  //用户名已存在
           writer.write(String.valueOf(checkResult));

       else if(code==null||!request.getSession().getAttribute("code").equals(request.getParameter("code")))  //验证码错误
           writer.write("4");

       else{    //注册成功，把记录插入到表中
           userInfoMapper.insert(userInfo);

           writer.write("1");
       }

        if(writer!=null){
            writer.flush();
            writer.close();
        }

       // return "success";
    }







    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        String s=request.getParameter("userName");
        return "login";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){

        return "admin";
    }

    @RequestMapping(value = "/quitLogin",method = RequestMethod.GET)
    public String quit(HttpServletRequest request){
        request.getSession().setAttribute("userName","");
        return "home";
    }
    

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){

        return "home";
    }
    @RequestMapping(value = "/sendCode",method = RequestMethod.POST)
    public @ResponseBody String sendCode(@RequestParam(value = "phone") String phone, HttpServletRequest request, HttpServletResponse response){

        
        code=Message.getResult(phone);
        request.getSession().setAttribute("code",code);
        return phone;

       // return "sendCode";
    }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView model=new ModelAndView("login");
        model.addObject("p","register");
        return model;
    }

    @RequestMapping(value = "/user_info",method = RequestMethod.GET)
    public String userInfo(){

        return "user_msg";
    }

    public static void jsonToResponse(JSONObject json, HttpServletResponse response)throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.flush();
                writer.close();
            }
        }
    }
    public String testPassword(){
        return loginService.getPwdByUname("hansen");
    }

}
