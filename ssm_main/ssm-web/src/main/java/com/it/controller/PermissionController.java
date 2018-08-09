package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.domain.Permission;
import com.it.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    //注入service
    @Autowired
    private IPermissionService permissionService;

    //保存
    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }

    //分页查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(required = false,defaultValue = "1")int pageNum,
            @RequestParam(required = false,defaultValue = "2")int pageSize
    ){
        //调用service
       List<Permission> list = permissionService.findAll(pageNum,pageSize);
       //调用PageInfo对象,封装分页结果
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        //返回结果
        ModelAndView mv = new ModelAndView();
        //存储查询结果,页面回显
        mv.addObject("pb",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
}
