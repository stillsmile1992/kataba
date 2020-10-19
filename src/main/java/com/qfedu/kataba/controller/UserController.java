package com.qfedu.kataba.controller;

import com.qfedu.kataba.service.intf.UserService;
import com.qfedu.kataba.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户controller
 * @createTime 2020/10/19 17:04
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all.do")
    public Result all() {
        return userService.all();
    }
}
