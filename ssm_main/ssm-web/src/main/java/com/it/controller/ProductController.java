package com.it.controller;

import com.it.domain.PageBean;
import com.it.domain.Product;
import com.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {
    //注入service
    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        //调用service查询
        List<Product> prodictList = productService.findAll();
        ModelAndView mv = new ModelAndView();
        //存储查询结果,页面回显
        mv.addObject("prodictList", prodictList);
        //转发页面
        mv.setViewName("product-list");
        return mv;
    }
    //添加保存
    @RequestMapping("/save")
    public String save(Product product){
        //调用service,保存
        productService.save(product);
        //重定向到列表
        return "redirect:/product/findAll";
    }
    //修改查询
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Long id){
        //调用service.查询
       Product product = productService.findById(id);
       //创建对象封装数据,返回
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }
    //修改保存
    @RequestMapping("/update")
    public String update (Product product){
        //调用service
        productService.update(product);
        return "redirect:/product/findAll";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String ids){
        //判断
        if (ids != null && !"".equals(ids)){
            //分割字符串
            String[] split = ids.split(",");
            for (String s : split) {
                productService.delete(Integer.parseInt(s));
            }
        }
        //重定向到列表
        return "redirect:/product/findAll";
    }

    //分页查询
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(
            @RequestParam(required = true,defaultValue = "1") int pageNum,
            @RequestParam(required = true,defaultValue = "2") int pageSize){
        //分查询
        PageBean<Product> page = productService.findByPage(pageNum, pageSize);
        System.out.println("复古风格发个"+page);
        //把page放到request域对象中
        ModelAndView mv = new ModelAndView();
        mv.addObject("page",page);
        //跳转页面
        mv.setViewName("product-list");
        return mv;
    }

}
