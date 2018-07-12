package com.yphone.service;

import com.yphone.mappers.*;
import com.yphone.model.nochange.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhansen on 2018/5/21.
 */
@Service
public class LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired AdminInfoMapper adminInfoMapper;

//    //数据库插入一个用户
//    public void saveUsesr(UserInfo user){
//        userInfoMapper.saveUser(user);
//    }

    //根据用户名查找密码
    public String getPwdByUname(String userName){
        return userInfoMapper.getPwdByUname(userName);
    }

    //根据手机号查找密码
    public String getPwdByPhone(String phone){
        return userInfoMapper.getPwdByPhone(phone);
    }

    public String getAdminPassword(String adminName){
        return adminInfoMapper.getAdminPassword(adminName);
    }

    //查询是否是管理员账户
    public boolean isAdminAccount(String adminName){
        return adminInfoMapper.isAdminExist(adminName)>0?true:false;
    }

    public String getNameByPhone(String phone){
        return userInfoMapper.getNameByPhone(phone);
    }
    public String getPhoneByName(String name){
        return userInfoMapper.getPhoneByName(name);
    }


    public int loginResult(String account,String password){
        if(!isPhone(account)){  //检测到如果不是用手机号登录
            //先在管理员表中查询账户是否存在
            if(isAdminAccount(account)){
                if(password.equals(adminInfoMapper.getAdminPassword(account)))
                    return 3;   //3-管理员登陆成功
                else
                    return 2;//2-账号或用户名密码错误
            }
            //如果不是管理员
            else {
                if (password.equals(userInfoMapper.getPwdByUname(account)))
                    return 1;//1-普通用户登录成功
                else
                    return 2;//2-账号或用户名密码错误
            }
        }
        //如果是用手机登录，则检测用户表
        else{
            if(password.equals(userInfoMapper.getPwdByPhone(account)))
                return 1; //普通用户登录成功
            else
                return 2;//2-账号或用户名密码错误
        }
    }
    //判断是手机号还是用户名
    public boolean isPhone(String account){
        return account.length()==11 && account.matches("[0-9]{11}");
    }

    //注册功能
    public int register(String phone,String userName){
        if(userInfoMapper.isPhoneExist(phone)>0)
            return 2;  //2-号码已被注册
        if(userInfoMapper.isUserNameExist(userName)>0)
            return 3;  //3-用户名已存在
        return 1;
    }



}
