package com.qfedu.kataba.service.intf;

import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.vo.Result;

import java.util.List;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description
 * @createTime 2020/10/19 17:08
 */
public interface UserService {

    Result<List<User>> all();
}
