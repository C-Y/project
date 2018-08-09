package com.it.service;

import com.it.domain.Permission;

import java.util.List;

public interface IPermissionService {

    //分页查询
    List<Permission> findAll(int pageNum, int pageSize);

    //保存
    void save(Permission permission);
}
