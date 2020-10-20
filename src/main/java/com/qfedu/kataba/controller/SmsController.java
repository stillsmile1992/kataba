package com.qfedu.kataba.controller;

import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.service.intf.SmsLogService;
import com.qfedu.kataba.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @project kataba
 * @description 短信controller
 * @author 徐天麒
 * @createTime 2020/10/20 9:26
 * @version 1.0
 */
@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsLogService smsLogService;

    @PostMapping("/sendrcode/{phone}")
    public Result sendRCode(@PathVariable String phone) {
        return smsLogService.sendRCode(phone);
    }

    @PostMapping("/checkrcode")
    public Result checkRCode(@RequestBody SmsRCodeDto smsRCodeDto) {
        return smsLogService.checkRCode(smsRCodeDto);
    }
}
