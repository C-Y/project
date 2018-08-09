package com.it.dao;

import com.it.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {
    //查询全部
    @Select("select * from product")
    List<Product> findAll();

    //保存
    @Insert("INSERT INTO product(productNum,productName,cityName,departureTime," +
            "productPrice,productDesc,productStatus)VALUES(#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    //主键查询
    @Select("select *from product where id = #{id}")
    Product findById(Long id);

    //修改页面
    @Update("update product set productNum=#{productNum},productName=#{productName}," +
            "cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice}," +
            "productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void update(Product product);

    //删除
    @Delete("delete from product where id = #{id}")
    void delete(int id);

    //分页查询
    @Select("select * from product limit #{pageNum},#{pageSize}")
    List<Product> findByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    //查询总页数
    @Select("select count(1) from product")
    int count();

}
