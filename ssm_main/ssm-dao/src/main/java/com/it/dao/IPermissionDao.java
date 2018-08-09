package com.it.dao;

import com.it.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    //查询全部
    @Select("select * from sys_permission")
    List<Permission> findAll();

    //保存
    @Insert("insert into sys_permission(permissionName,url,pid)values(#{permissionName},#{url},#{pid})")
    void save(Permission permission);

    //用户详情,根据roleId查询用户权限和角色
    @Select("SELECT p.* FROM sys_permission p INNER JOIN sys_role_permission rp ON p.id = rp.permissionId WHERE rp.roleId = #{id}")
    List<Permission> findPermissionsByRoleId(long id);
}
