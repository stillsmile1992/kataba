package com.qfedu.kataba.test;

import com.qfedu.kataba.utils.EncryptUtil;
import org.junit.jupiter.api.Test;

/**
 * @project kataba
 * @description 密码测试类
 * @author 徐天麒
 * @createTime 2020/10/20 16:28
 * @version 1.0
 */
public class Pass_Test {

    @Test
    public void t1(){
        String key = EncryptUtil.createAESKey();
        System.out.println("key = " + key);
        String pass = "123456";
        String aesenc = EncryptUtil.aesenc(key, pass);
        System.out.println("aesenc = " + aesenc);
        System.out.println(EncryptUtil.aesdec(key,aesenc));
    }
}
