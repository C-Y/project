package com.it.service;

import com.it.domain.Orders;

import java.util.List;

public interface IOrderService {
    //查询全部
    List<Orders> findAll();

    //分页查询 ,当前页和页大小
    List<Orders> findByPage(int pageNum,int pageSize);
}
