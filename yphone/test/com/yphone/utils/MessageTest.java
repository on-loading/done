package com.yphone.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getResult() {
        String code=Message.getResult("15927612900");
        assertEquals(6,code.length());
        //assertNotNull(Message.getResult("15927612900"));
       // String code=Md5Utils.md5("tanajiya.tar.gz");
        System.out.println(code);
        assertNotNull(code);
    }
}