package com.qfedu.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.entity.SmsLog;
import org.springframework.stereotype.Repository;

/**
 * @project kataba
 * @description 短信日志dao
 * @author 徐天麒
 * @createTime 2020/10/20 9:35
 * @version 1.0
 */
@Repository
public interface SmsLogDao extends BaseMapper<SmsLog> {
}
