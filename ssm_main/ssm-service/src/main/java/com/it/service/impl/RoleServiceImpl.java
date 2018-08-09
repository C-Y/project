package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.it.dao.IRoleDao;
import com.it.domain.Role;
import com.it.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    //注入dao
    @Autowired
    private IRoleDao roleDao;

    //保存用户
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    //分页查询
    @Override
    public List<Role> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return roleDao.findAll();
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
