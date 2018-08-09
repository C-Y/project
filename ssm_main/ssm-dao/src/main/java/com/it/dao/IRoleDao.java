package com.it.dao;


import com.it.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {
    //查询全部
    @Select("select * from sys_role")
    List<Role> findAll();

    //保存用户
    @Insert("insert into sys_role (roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role);

    //用户详情,根据用户查询角色
    @Select("select r.* from sys_role r inner join sys_user_role ur on r.id = ur.roleId where ur.userId = #{id}  ")
    @Results({
            @Result(property = "permissions",column = "id",javaType = List.class,
            many = @Many(select = "com.it.dao.IPermissionDao.findPermissionsByRoleId",fetchType = FetchType.LAZY))
    })
    List<Role> findRolesByUserId(long id);
}
