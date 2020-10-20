package com.qfedu.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.entity.UserLog;
import org.springframework.stereotype.Repository;

/**
 * @project kataba
 * @description 用户日志dao
 * @author 徐天麒
 * @createTime 2020/10/20 9:18
 * @version 1.0
 */
@Repository
public interface UserLogDao extends BaseMapper<UserLog> {
}
