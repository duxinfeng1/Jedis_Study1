package com.dxf.shiro.mapper;


import com.dxf.shiro.domain.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface UserRoleMapper {
    @Insert("    insert into t_userrole (uid, rid) values (#{uid,jdbcType=INTEGER}, #{rid,jdbcType=INTEGER})")
    int insert(UserRole record);

    @Delete("delete from t_userrole where id = #{id,jdbcType=INTEGER}")
    int delete(Integer id);

}