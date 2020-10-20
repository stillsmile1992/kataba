package com.qfedu.kataba.utils;

import java.util.Random;

/**
 * @project kataba
 * @description 随机生成验证码
 * @author 徐天麒
 * @createTime 2020/10/20 9:58
 * @version 1.0
 */
public class NumRandomUtil {

    /**
     * 生成指定位数随机数
     * @param length
     * @return
     */
    public static int randomNum(int length) {
        Random random = new Random();
        double d = Math.pow(10, length - 1);
        return random.nextInt((int) (Math.pow(10, length) - d)) + (int) d;
    }
}
