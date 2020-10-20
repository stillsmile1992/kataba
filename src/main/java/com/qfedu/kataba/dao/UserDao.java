package com.qfedu.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
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

    /**
     * 按姓名查询
     * @param n
     * @return
     */
    @Select("select * from t_user where nickname = #{n} or phone = #{n}")
    @ResultType(User.class)
    User selectByName(String n);

    /**
     * 按姓名或手机查询
     * @param n
     * @param p
     * @return
     */
    @Select("select * from t_user where nickname = #{n} or phone = #{n}")
    @ResultType(User.class)
    User selectByNamePhone(@Param("n") String n,@Param("p") String p);

    /**
     * 插入用户
     * @param userDto
     * @return
     */
    @Insert("insert into t_user (nickname,phone,password,flag) values (#{nname},#{phone},#{pwd},1)")
    int insertDto(UserDto userDto);
}
