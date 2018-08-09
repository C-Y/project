package com.it.service;

import com.it.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    //查询 用户列表
    List<SysUser> findAll(int pageNum, int pageSize);
    //用户添加
    void save(SysUser sysUser);

    //用户详情
    SysUser findById(Long id);

    SysUser toUserRole(Long id);

    void addRoleToUser(Long userId, Long[] ids);
}
