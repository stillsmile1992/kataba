package com.qfedu.kataba.utils;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 判断非空
 * @createTime 2020/10/19 17:29
 */
public class StrUtil {

    /**
     * 检验是否为空
     */
    public static boolean checkNotEmpty(String... strings) {
        boolean flag = true;
        for (String string : strings) {
            if (string == null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
