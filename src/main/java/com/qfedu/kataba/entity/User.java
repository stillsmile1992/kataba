package com.qfedu.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 实体类
 * @createTime 2020/10/19 17:13
 */
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String nickname;
    private String password;
    private int flag;
}
