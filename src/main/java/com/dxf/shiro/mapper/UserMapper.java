package com.dxf.shiro.mapper;


import com.dxf.shiro.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into t_user (no, username, password, createdate, flag) values (#{no,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{createdate,jdbcType=DATE}, #{flag,jdbcType=INTEGER})")
    int insert(User record);

    @Select("select * from t_user where name=#{name} or no=#{no}")
    User selectByName(String name);

    @Update("update t_user set password=#{newpass} where id=#{uid} and password=#{oldpass}")
    int updatePass(@Param("uid") int uid, @Param("oldpass") String oldpass, @Param("newpass") String newPass);

    //查询数量
    @Select("select COUNT(*) from t_user where flag=#{flag}")
    @ResultType(long.class)
    long selectCount(int flag);

    //分页查询
    @Select("select * from t_user where flag=#{flag} order by createdate desc limit #{index},#{count}")
    @ResultType(User.class)
    List<User> selectByPage(@Param("index") int index, @Param("count") int count, @Param("flag")int flag);

}