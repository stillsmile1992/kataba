package com.qfedu.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.kataba.dao.UserDao;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.service.intf.UserService;
import com.qfedu.kataba.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description
 * @createTime 2020/10/19 17:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<List<User>> all() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.ok(userDao.selectList(queryWrapper));
    }
}
