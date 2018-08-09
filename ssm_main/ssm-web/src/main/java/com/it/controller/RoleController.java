package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.domain.Role;
import com.it.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/role")
/*//方式1:后台权限校验(JSP-250),访问当前类需要的权限
@RolesAllowed("ROLE_ADMIN")
//方式2:springsecurity提供的权限校验方法
@Secured("ROLE_ADMIN")*/
//方式3:spel表达式提供的权限校验支持
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class RoleController {
    //注入service
    @Autowired
    private IRoleService roleService;

    //添加用户
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll";
    }
    //分页列表
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(required = false, defaultValue = "1") int pageNum,
            @RequestParam(required = false, defaultValue = "2") int pageSize
    ) {
        //调用service
       List<Role> list =  roleService.findAll(pageNum,pageSize);
       //封装分页结果数据
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        //返回结果
        ModelAndView mv =new ModelAndView();
        mv.addObject("pb",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }
}
