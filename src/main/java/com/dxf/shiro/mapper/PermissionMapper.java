package com.dxf.shiro.mapper;


import com.dxf.shiro.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PermissionMapper {

    @Insert("insert into t_permission (name, parentid, icon, type, pers, createdate) values (#{name,jdbcType=VARCHAR}, #{parentid,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, #{pers,jdbcType=VARCHAR}, #{createdate,jdbcType=DATE})")
    @Options(useGeneratedKeys = true)
    int insert(Permission record);

    @Select("select * from t_permission where id=#{id}")
    @ResultType(Permission.class)
    Permission selectById(Integer id);

    //查询用户的权限
    @Select("select p.pers from t_permission p left join t_rolepermission rp on p.id=rp.pid left join t_userrole ur on rp.rid=ur.rid where ur.uid=#{uid};")
    @ResultType(String.class)
    List<String> selectByUid(int uid);

    @Select("select * from t_permission limit #{index},#{count}")
    @ResultType(Permission.class)
    List<Permission> selectByPage(@Param("index") int index, @Param("count") int count);

    @Select("select COUNT(*) from t_permission")
    @ResultType(long.class)
    long selectCount();

    @Select("select p.* from  t_permission p left join t_rolepermission rp on p.id=rp.pid left join t_userrole ur on ur.rid=rp.rid left join t_user u on ur.uid=u.id where p.type=1 and u.id=1 order by p.parentid,p.id;")
    @ResultType(Permission.class)
    List<Permission> selectByMenuUid(int uid);
}