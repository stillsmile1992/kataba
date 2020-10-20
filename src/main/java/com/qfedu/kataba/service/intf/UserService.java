package com.qfedu.kataba.service.intf;

import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.dto.UserLoginDto;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.vo.Result;

import java.util.List;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户业务类
 * @createTime 2020/10/19 17:08
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    Result<List<User>> all();

    /**
     * 校验手机
     * @param phone
     * @return
     */
    Result checkPhone(String phone);

    /**
     * 检验昵称
     * @param name
     * @return
     */
    Result checkNickName(String name);

    /**
     * 注册
     * @param userDto
     * @return
     */
    Result register(UserDto userDto);

    /**
     * 登录
     * @param userLoginDto
     * @return
     */
    Result login(UserLoginDto userLoginDto);

    /**
     * 找回密码
     * @param userDto
     * @return
     */
    Result findPassword(UserDto userDto);
}
