package com.huashitu.liveradio.api;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class Constant {

    public static String BASEURL="http://115.159.145.219:8080/SanhaiApp";


    public static String HOT="http://live.9158.com/Fans/GetHotLive";

    /**
     * 登录
     */
    public static String LOGIN=BASEURL+"/user/login";

    /**
     * 注册
     */
    public static String REGISTER=BASEURL+"/user/register";

    /**
     * 发送验证码
     */
    public static String SENDCODE=BASEURL+"/validateCode/send_code";

    /**
     * 验证验证码
     */
    public static String VALIDATECODE=BASEURL+"/validateCode/validate_code";
}
