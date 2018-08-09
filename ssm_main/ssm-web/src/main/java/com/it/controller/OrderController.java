package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.domain.Orders;
import com.it.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    //注入Service
    @Autowired
    private IOrderService orderService;
    //查询全部列表
    @RequestMapping("/findAll_old")
    public ModelAndView findAll(){
        List<Orders> ordersList = orderService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("order-list");
        return mv;
    }
    @RequestMapping("/findByPage")
    public ModelAndView find(
            @RequestParam(required = false,defaultValue = "1") int pageNum,
            @RequestParam(required = false,defaultValue = "2") int pageSize
    ){
        List<Orders> ordersList = orderService.findByPage(pageNum,pageSize);
        PageInfo<Orders> pageInfo= new PageInfo<>(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pb",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }
}
