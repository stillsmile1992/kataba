package com.qfedu.kataba.service.intf;

import com.qfedu.kataba.entity.UserLog;
import com.qfedu.kataba.vo.Result;

/**
 * @project kataba
 * @description 用户日志业务类
 * @author 徐天麒
 * @createTime 2020/10/20 9:32
 * @version 1.0
 */
public interface UserLogService {

    /**
     * 新增用户日志
     * @param userLog
     * @return
     */
    Result save(UserLog userLog);
}
