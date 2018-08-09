package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.it.dao.IPermissionDao;
import com.it.domain.Permission;
import com.it.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService{
    //注入dao
    @Autowired
    private IPermissionDao permissionDao;

    //分页查询
    @Override
    public List<Permission> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return permissionDao.findAll();
    }
    //保存
    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
