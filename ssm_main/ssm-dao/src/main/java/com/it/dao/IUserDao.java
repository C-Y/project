package com.it.dao;

import com.it.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface IUserDao {
    //根据条件查询用户
    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
            many = @Many(select = "com.it.dao.IRoleDao.findRolesByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findByUsername(String username);

    //查询全部
    @Select("select * from sys_user ")
    List<SysUser> findAll();

    //保存用户
    @Insert("insert into sys_user (username,email,password,phoneNum,status)" +
            "values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);

    //查询用户
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.it.dao.IRoleDao.findRolesByUserId",fetchType = FetchType.LAZY) )
    })
    SysUser findById(Long id);

    //删除用户角色
    @Delete("delete from sys_user_role where userId = #{userId}")
    void deleteUserRoleByUserId(Long userId);

    //给用户添加角色
    @Insert("insert into sys_user_role(userId,roleId)values(#{userId},#{roleId})")
    void saveUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

}
