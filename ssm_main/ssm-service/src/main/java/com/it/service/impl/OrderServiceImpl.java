package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.it.dao.IOrderDao;
import com.it.domain.Orders;
import com.it.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService{
    //dao注入
    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Orders> findAll() {
        return orderDao.finAll();
    }

    @Override
    public List<Orders> findByPage(int pageNum, int pageSize) {
        //使用PageHelper进行分页
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着PageHelper.startPage()后的第一行查询代码.会自动进行分页查询
        return orderDao.finAll();
    }
}
