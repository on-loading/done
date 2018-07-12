package com.yphone.mappers;

import com.yphone.mappers.nochange.MBGPhoneInfoMapper;
import com.yphone.model.nochange.PhoneInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PhoneInfoMapper extends MBGPhoneInfoMapper {

    List<String> getType();

    List<String> getNamesByType(String type);

    PhoneInfo getPhoneByName(String name);


    List<Map<String,Object>> selectByType(String type);

    PhoneInfo selectByMinID();

    String getNameByID(long ID);


}