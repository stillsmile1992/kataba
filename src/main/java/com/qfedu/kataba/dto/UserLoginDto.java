package com.qfedu.kataba.dto;

import lombok.Data;

/**
 * @project kataba
 * @description 用户登录
 * @author 徐天麒
 * @createTime 2020/10/20 9:21
 * @version 1.0
 */
@Data
public class UserLoginDto {

    /**
     * 昵称或手机号
     */
    private String name;

    private String pwd;

}
