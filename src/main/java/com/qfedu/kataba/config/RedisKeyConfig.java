package com.qfedu.kataba.config;

/**
 * @project kataba
 * @description 存储Redis中key的名字
 * @author 徐天麒
 * @createTime 2020/10/20 10:16
 * @version 1.0
 */
public class RedisKeyConfig {

    /**
     * 注册验证码
     */
    public static final String SMS_RCODE = "kataba:sms:rcode:";

    /**
     * 验证码有效期
     */
    public static final int RCODE_TIME = 600;

    /**
     * 存储令牌
     */
    public static final String LOGIN_TOKEN = "kataba:login:token:";

    /**
     * 存储登录id
     */
    public static final String LOGIN_USER = "kataba:login:uid:";

    /**
     * 存储登录时间
     */
    public static final int LOGIN_TIME = 1800;
}
