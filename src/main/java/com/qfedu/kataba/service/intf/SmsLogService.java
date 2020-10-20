package com.qfedu.kataba.service.intf;

import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.vo.Result;

/**
 * @project kataba
 * @description 短信日志业务类
 * @author 徐天麒
 * @createTime 2020/10/20 9:28
 * @version 1.0
 */
public interface SmsLogService {

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    Result sendRCode(String phone);

    /**
     * 验证验证码
     * @param smsRCodeDto
     * @return
     */
    Result checkRCode(SmsRCodeDto smsRCodeDto);
}
