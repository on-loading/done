package com.yphone.service;

import com.alibaba.fastjson.JSONObject;
import com.yphone.mappers.PhoneInfoMapper;
import com.yphone.model.nochange.PhoneInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    private PhoneInfoMapper phoneInfoMapper;

    public List<String> getType(){
        return phoneInfoMapper.getType();
    }

    public List<String> getNamesByType(String type){
        return phoneInfoMapper.getNamesByType(type);
    }

    public PhoneInfo getPhoneByName(String name){
        return phoneInfoMapper.getPhoneByName(name);
    }

    public String getNameByID(long ID){
        return phoneInfoMapper.getNameByID(ID);
    }

    public  PhoneInfo getPhoneByID(Long ID){
        return phoneInfoMapper.selectByPrimaryKey(ID);
    }

    public PhoneInfo selectByMinID(){
        return phoneInfoMapper.selectByMinID();
    }
//    public JSONObject getPhoneJson(PhoneInfo phoneInfo){
//        JSONObject jsonObject=JSONObject.fromObject(phoneInfo);
//        return jsonObject;
//
//    }

    public JSONObject getJsonByType(List<String> type){
        JSONObject json=new JSONObject();
        for(String s:type){
            json.put(s,phoneInfoMapper.selectByType(s));
        }
        return json;

    }

    public List<Map<String,Object>> testType(String type){
        List<Map<String,Object>> result=phoneInfoMapper.selectByType(type);
        return result;
    }



}
