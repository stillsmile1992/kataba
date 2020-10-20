package com.qfedu.kataba.service.impl;

import com.qfedu.kataba.config.RedisKeyConfig;
import com.qfedu.kataba.dao.SmsLogDao;
import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.service.intf.SmsLogService;
import com.qfedu.kataba.third.JedisUtil;
import com.qfedu.kataba.third.SmsUtil;
import com.qfedu.kataba.utils.NumRandomUtil;
import com.qfedu.kataba.utils.StrUtil;
import com.qfedu.kataba.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project kataba
 * @description 短信业务实现类
 * @author 徐天麒
 * @createTime 2020/10/20 9:34
 * @version 1.0
 */
@Service
public class SmsLogServiceImpl implements SmsLogService {

    @Autowired
    private SmsLogDao smsLogDao;

    @Override
    public Result sendRCode(String phone) {

        int code = NumRandomUtil.randomNum(6);
        if (SmsUtil.sendRCode(phone, code)) {
            JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.SMS_RCODE + phone, RedisKeyConfig.RCODE_TIME, code + "");
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result checkRCode(SmsRCodeDto smsRCodeDto) {
        if (StrUtil.checkNotEmpty(smsRCodeDto.getPhone())) {

            String k = RedisKeyConfig.SMS_RCODE + smsRCodeDto.getCode();

            if (JedisUtil.getInstance().getJedis().exists(k)) {
                if (smsRCodeDto.getCode() == Integer.parseInt(JedisUtil.getInstance().STRINGS.get(k))) {
                    return Result.ok();
                }
            }
        }
        return Result.fail();
    }
}
