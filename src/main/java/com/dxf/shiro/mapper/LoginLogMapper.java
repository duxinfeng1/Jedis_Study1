package com.dxf.shiro.mapper;


import com.dxf.shiro.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;

public interface LoginLogMapper {

    @Insert("insert into t_loginlog (uid, createtime, ip) values (#{uid,jdbcType=INTEGER}, #{createtime,jdbcType=DATE},  #{ip,jdbcType=VARCHAR})")
    int insert(LoginLog record);

}