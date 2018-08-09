package com.it.service.impl;

import com.it.dao.IProductDao;
import com.it.domain.PageBean;
import com.it.domain.Product;
import com.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service//对象加入IOC容器
@Transactional//使用Spring声明式事务
public class ProoductServiceImpl implements IProductService{
    //注入Dao
    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Long id) {
       return productDao.findById( id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    //分页查询
    @Override
    public PageBean<Product> findByPage(int pageNum, int pageSize) {
        //初始化当前页
        if (pageNum<1)pageNum = 1;
        PageBean<Product> pb = new PageBean<>();
        //分页查询数据
        List<Product> list = productDao.findByPage((pageNum - 1) * pageSize, pageSize);
        pb.setList(list);
        pb.setPageNum(pageNum);
        pb.setPageSize(pageSize);
        //查询总页数
        int count = productDao.count();
        pb.setTotalCount(count);

        return pb;
    }
}
