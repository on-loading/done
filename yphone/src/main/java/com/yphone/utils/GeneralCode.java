package com.yphone.utils;

import java.util.Random;

public class GeneralCode {

    public static String getCode() {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        int i = 0;
        while (i++ < 6) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();

    }
}
