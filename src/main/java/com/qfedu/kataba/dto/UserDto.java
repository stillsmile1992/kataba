package com.qfedu.kataba.dto;

import lombok.Data;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户dto 传输数据
 * @createTime 2020/10/19 17:27
 */
@Data
public class UserDto {
    private String phone;
    private String nname;
    private String pwd;
}
