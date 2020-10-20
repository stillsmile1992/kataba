package com.qfedu.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.kataba.config.RedisKeyConfig;
import com.qfedu.kataba.dao.UserDao;
import com.qfedu.kataba.dao.UserLogDao;
import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.dto.UserLoginDto;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.entity.UserLog;
import com.qfedu.kataba.service.intf.UserService;
import com.qfedu.kataba.third.JedisUtil;
import com.qfedu.kataba.third.JwtUtil;
import com.qfedu.kataba.utils.EncryptUtil;
import com.qfedu.kataba.utils.StrUtil;
import com.qfedu.kataba.vo.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户业务实现类
 * @createTime 2020/10/19 17:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLogDao userLogDao;

    @Value("${kataba.passkey}")
    private String pk;

    @Override
    public Result<List<User>> all() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.ok(userDao.selectList(queryWrapper));
    }

    @Override
    public Result checkPhone(String phone) {
        if (StrUtil.checkNotEmpty(phone)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);
            if (userDao.selectOne(queryWrapper) != null) {
                return Result.fail();
            } else {
                return Result.ok();
            }
        }
        return Result.fail();
    }

    @Override
    public Result checkNickName(String name) {
        if (StrUtil.checkNotEmpty(name)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("nickname", name);
            if (userDao.selectOne(queryWrapper) != null) {
                return Result.fail();
            } else {
                return Result.ok();
            }
        }
        return Result.fail();
    }

    @Override
    @Transactional
    public Result register(UserDto userDto) {

        //检验是否可用
        User user = userDao.selectByNamePhone(userDto.getNname(), userDto.getPhone());

        if (user == null) {
            userDto.setPwd(EncryptUtil.aesenc(pk, userDto.getPwd()));
            User newUser = new User(userDto.getPhone(), userDto.getNname(), userDto.getPwd(), 1);
            if (userDao.insert(newUser) > 0) {
                UserLog userLog = new UserLog(newUser.getId(), 1, "注册新用户", new Date());
                userLogDao.insert(userLog);
                return Result.ok();
            }
        }
        return Result.fail();
    }

    @Override
    @Transactional
    public Result login(UserLoginDto userLoginDto) {
        //1.检验
        User user = userDao.selectByName(userLoginDto.getName());
        if (user != null) {
            //2.比较密码
            if (EncryptUtil.aesenc(pk, userLoginDto.getPwd()).equals(user.getPassword())) {
                //密码一致
                //3.生成令牌
                String token = JwtUtil.createToken(user.getPhone());
                //4.存储令牌
                //记录令牌对应的用户
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_TOKEN + token, RedisKeyConfig.LOGIN_TIME, new JSONObject(user).toString());
                //记录登录过的账号信息
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_USER + user.getId(), RedisKeyConfig.LOGIN_TIME, token);
                //5.加入日志
                UserLog userLog = new UserLog(user.getId(), 2, "用户登录", new Date());
                userLogDao.insert(userLog);
                //6.返回
                return Result.ok(token);
            }
        }
        return Result.fail();
    }

    @Override
    public Result findPassword(UserDto userDto) {
        return null;
    }
}
