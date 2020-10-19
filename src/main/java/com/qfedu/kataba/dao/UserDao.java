package com.qfedu.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户dao
 * @createTime 2020/10/19 17:17
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
