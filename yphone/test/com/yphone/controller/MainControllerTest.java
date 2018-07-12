package com.yphone.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yphone.config.DruidDataSourceConfig;
import com.yphone.config.RootConfig;
import com.yphone.config.WebAppInitializar;
import com.yphone.mappers.*;
import com.yphone.model.nochange.AddressUsed;
import com.yphone.model.nochange.Order;
import com.yphone.model.nochange.OrderGenerator;
import com.yphone.service.LoginService;

import com.yphone.service.PhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, DruidDataSourceConfig.class,WebAppInitializar.class})
//@WebAppConfiguration
public class MainControllerTest {

    @Autowired
    private LoginService service;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private OrderGeneratorMapper orderGeneratorMapper;

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    AddressUsedMapper addressUsedMapper;

    @Autowired
    OrderMapper orderMapper;


    @Test
    public void testHomePage(){
         assertNotNull(addressUsedMapper);
        List<AddressUsed> addressUseds=addressUsedMapper.selectByUserID((long)2);
        assertNotNull(addressUseds);
        AddressUsed add=new AddressUsed();
        add.setUserId((long)2);
        add.setReceiver("susa");
        add.setPhone("89245");
        add.setAddressDetail("shgfoahphap");
        add.setGmtCreate(new Date());
        add.setGmtModified(new Date());
        addressUsedMapper.insert(add);


    }

    @Test
    public void testOrder(){
        String tailNum="6332";  //获取手机尾号，4位
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String MAndD=sdf.format(date).replaceAll("-",""); //获取月日，4位

        OrderGenerator orderGenerator=new OrderGenerator();
        orderGenerator.setDateNum(MAndD);
        orderGenerator.setPhoneLast4(tailNum);
        orderGeneratorMapper.insertSelective(orderGenerator);

        int id=(int)(orderGenerator.getOrderGeneratorId()%1000000);
        String ID="000000".substring(String.valueOf(id).length())+String.valueOf(id);
        String orderID= ID+MAndD+tailNum;

        Order order=new Order();
        order.setOrderId(orderID);
        order.setUserId((long)2);
        order.setReceiver("people");
        order.setNum(3);
        order.setPhone("15924646461");
//        order.setGmtCreate(date);
//        order.setGmtModified(date);
        order.setPrice(new BigDecimal(9238));
        order.setAddress("湖北省武汉市洪山区珞喻路华中科技大学");
        order.setPhoneId((long)3);
        order.setStatus(1);
        int result=orderMapper.insertSelective(order);
        assertEquals(1,result);




    }


}