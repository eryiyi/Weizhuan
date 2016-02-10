package com.liangxunwang.unimanager.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class SMSMessage
{
    /**
     * 通过URL地址的形式发送短信
     * @param mobileNum
     * @param content
     * @return
     */
    public static String sendMobileMessageByURL(String mobileNum,String content) {
        String state = "0";
        try {
            URL url = new URL(Constants.SMS_MESSAGE_URL);//短信URL地址
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            String MobileMessageInfo = "CORPID=xunliang&CPPW="+MessageMD5.MD5("lxw888")+"&PHONE="+mobileNum+"&CONTENT="+content;
            out.write(MobileMessageInfo);
            out.flush();
            out.close();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            state = in.readLine();//1为短信发送成功，否则短信发送失败
            in.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return state;
    }

    public static void main(String args[]){
        String num = String.valueOf((int)((Math.random()*9+1)*100000));
        String a =sendMobileMessageByURL("15065286110","【良讯网】"+num+"( 良讯网手机注册验证码，请完成验证)，如非本人操作，请忽略本短信。");

        System.out.print(a);
    }
}
