package com.qfedu.kataba.dto;

import lombok.Data;

/**
 * @project kataba
 * @description 短信验证码
 * @author 徐天麒
 * @createTime 2020/10/20 9:29
 * @version 1.0
 */
@Data
public class SmsRCodeDto {

    private String phone;

    private int code;
}
