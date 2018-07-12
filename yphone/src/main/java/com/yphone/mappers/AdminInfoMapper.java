package com.yphone.mappers;

import com.yphone.mappers.nochange.MBGAdminInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AdminInfoMapper extends MBGAdminInfoMapper {
    //查询管理员账号是否存在
    int isAdminExist(@Param("adminName") String adminName);

    //获取管理员密码
    String getAdminPassword(String sadminName);
}