package com.qfedu.kataba.vo;

import com.qfedu.kataba.core.type.RType;
import lombok.Data;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description
 * @createTime 2020/10/19 17:08
 */
@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> R setR(int c, String m, T obj) {
        R r = new R();
        r.setCode(c);
        r.setData(obj);
        r.setMsg(m);
        return r;
    }

    public static R ok() {
        return setR(RType.成功.getVal(), "OK", null);
    }

    public static <T> R ok(T t) {
        return setR(RType.成功.getVal(), "OK", t);
    }

    public static R fail() {
        return setR(RType.失败.getVal(), "FAIL", null);
    }
}
