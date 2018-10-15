package com.dxf.shiro.mapper;


import com.dxf.shiro.domain.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface RolePermissionMapper {

    @Delete("delete from t_role where rid=#{rid}")
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into t_rolepermission (rid, pid)values (#{rid,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER})")
    int insert(RolePermission record);


}