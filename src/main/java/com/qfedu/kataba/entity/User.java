package com.qfedu.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 用户实体类
 * @createTime 2020/10/19 17:13
 */
@Data
@TableName("t_user")
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String nickname;
    private String password;
    private int flag;

    public User(String phone, String nickname, String password, int flag) {
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.flag = flag;
    }
}
