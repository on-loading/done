package com.yphone.mappers;

import com.yphone.config.DruidDataSourceConfig;
import com.yphone.config.RootConfig;
import com.yphone.config.WebAppInitializar;
import com.yphone.model.nochange.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void getPwdByPhone() {
        assertNotNull(userInfoMapper);
        assertEquals("a12345",userInfoMapper.getPwdByPhone("15920000000"));
        UserInfo user=new UserInfo();

        user.setPhone("15921111112");
        user.setPassword("00000000");
        user.setUserName("nobady2");
        assertEquals(1,userInfoMapper.insert(user));
    }

}