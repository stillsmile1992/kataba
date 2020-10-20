package com.qfedu.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @project kataba
 * @description 用户日志实体类
 * @author 徐天麒
 * @createTime 2020/10/20 9:17
 * @version 1.0
 */
@Data
@TableName("t_userlog")
public class UserLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer type;
    private String content;
    private Date ctime;
}
