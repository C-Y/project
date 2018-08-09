package com.it.service;

import com.it.domain.PageBean;
import com.it.domain.Product;

import java.util.List;

public interface IProductService {
    //查询全部
    List<Product> findAll();
    //保存
    void save(Product product);
    //通过id查询
    Product findById(Long id);
    //修改
    void update(Product product);
    //删除
    void delete(int i);

    //分页查询
    PageBean<Product> findByPage(int pageNum,int pageSize);
}
