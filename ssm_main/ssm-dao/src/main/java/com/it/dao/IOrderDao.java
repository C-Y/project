package com.it.dao;

import com.it.domain.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderDao {
    //查询全部
    @Select("select o.id as oid,o.orderNum,o.orderTime,o.peopleCount," +
            "o.orderDesc,o.payType,o.orderStatus,p.* from " +
            "orders o,product p where o.productId = p.id")
    @Results({
            //映射Order订单信息
            @Result(id =true, property = "id",column = "oid"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            //查询映射Product产品信息
            @Result(property = "product.id",column = "id"),
            @Result(property = "product.productNum",column = "productNum"),
            @Result(property = "product.productName",column = "productName"),
            @Result(property = "product.cityName",column = "cityName"),
            @Result(property = "product.departureTime",column = "departureTime"),
            @Result(property = "product.productPrice",column = "productPrice"),
            @Result(property = "product.productDesc",column = "productDesc"),
            @Result(property = "product.productStatus",column = "productStatus")
    })
    List<Orders> finAll();


    //分页查询
    @Select("select o.id as oid,o.orderNum,o.orderTime,o.peopleCount," +
            "o.orderDesc,o.payType,o.orderStatus,p.* from " +
            "orders o,product p where o.productId = p.id")
    @Results({
            //映射Order订单信息
            @Result(id =true, property = "id",column = "oid"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            //查询映射Product产品信息
            @Result(property = "product.id",column = "id"),
            @Result(property = "product.productNum",column = "productNum"),
            @Result(property = "product.productName",column = "productName"),
            @Result(property = "product.cityName",column = "cityName"),
            @Result(property = "product.departureTime",column = "departureTime"),
            @Result(property = "product.productPrice",column = "productPrice"),
            @Result(property = "product.productDesc",column = "productDesc"),
            @Result(property = "product.productStatus",column = "productStatus")
    })
    List<Orders> findByPage();

}
