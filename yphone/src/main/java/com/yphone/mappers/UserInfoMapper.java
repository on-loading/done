package com.yphone.mappers;

import com.yphone.mappers.nochange.MBGUserInfoMapper;
import com.yphone.model.nochange.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public interface UserInfoMapper extends MBGUserInfoMapper {

    String getPwdByUname(@Param("userName") String userName);
    String getPwdByPhone(@Param("phone") String phone);
    String getPhoneByName(String useName);
    String getNameByPhone(String phone);
    long getUserIDByPhone(String phone);
    int isPhoneExist(String phone);
    int isUserNameExist(String userName);
    long getUserIDByUsername(String username);


}