package com.qfedu.kataba.core.type;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 枚举 也可用常量类
 * @createTime 2020/10/19 17:11
 */
public enum RType {
    成功(1), 失败(2), 登录失败(3);

    private int val;

    public int getVal() {
        return val;
    }

    private RType(int v) {
        val = v;
    }
}
