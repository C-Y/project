package com.it.service;

import com.it.domain.Role;

import java.util.List;

public interface IRoleService {
    //角色分页显示
    List<Role> findAll(int pageNum, int pageSize);
    //查询全部
    List<Role> findAll();

    //保存用户
    void save(Role role);
}
