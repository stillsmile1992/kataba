package com.qfedu.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class UserLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer type;
    private String content;
    private Date ctime;

    public UserLog(Integer uid, Integer type, String content, Date ctime) {
        this.uid = uid;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }
}
