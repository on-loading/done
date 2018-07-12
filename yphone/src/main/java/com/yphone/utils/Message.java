package com.yphone.utils;

import net.sf.json.JSONObject;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Message {

    /**
     * 用户ID
     */
    public static final String ACCOUNT_SID = "09fcab69b5ea42fdbdf593159b83bca3";//这里填写你在平台里的ACOUNT_SID

    /**
     * 密钥
     */
    public static final String AUTH_TOKEN = "61bd83f9d4714d8f89851cbe6a12ed87";

    /**
     * 请求地址前半部分
     */
    public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//请求地址是固定的不用改

    public static  String randNum = GeneralCode.getCode();

    public  static String smsContent = "【****】您的验证码为"+randNum+"，请于"+5+"分钟内正确输入，如非本人操作，请忽略此短信。";
    /**
     * (获取短信验证码)
     * @param to
     * @return String
     */
    public static String getResult(String to) {
        randNum = GeneralCode.getCode();
        String smsContent = "【E购网】您的验证码为"+randNum+"，请于"+5+"分钟内正确输入，如非本人操作，请忽略此短信。";            //这里的randNum 和 smsContent和上面的静态变量是一样的，可删除可保留
        String args = QueryUtil.queryArguments(ACCOUNT_SID, AUTH_TOKEN, smsContent, to);
        OutputStreamWriter out = null;
        InputStream in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();


        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection(); //打开链接
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);  //设置链接超时
            connection.setReadTimeout(10000);    //设置读取超时

            //提交数据
            out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
            out.write(args);
            out.flush();

            //读取返回数据
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        System.out.println(jsonObject);
        Object object = jsonObject.get("respCode");
        System.out.println("状态码："+object+"验证码："+randNum);
        //System.out.println(!object.equals("00000"));
        if (!object.equals("00000")) {
            return object.toString();
        }else{

            return randNum;
        }


    }
    // 测试功能
//    public static void main(String[] args) {
//        String result = getResult("15927612900");
//        System.out.println("验证码："+randNum+"\t"+result);
//    }

}
