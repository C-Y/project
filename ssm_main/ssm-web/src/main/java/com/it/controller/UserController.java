package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.domain.Role;
import com.it.domain.SysUser;
import com.it.service.IRoleService;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入service
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    //给用户添加用户
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Long userId,Long[] ids){
        //调用servcie,给用户添加角色
        userService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll";
    }


    //用户角色
    @RequestMapping("/toUserRole")
    public ModelAndView toUserRole(Long id){
        //查询用户
        SysUser sysUser = userService.toUserRole(id);
        //用户具有的角色
        List<Role> roles = sysUser.getRoles();
        StringBuffer sb = new StringBuffer();
        if (roles != null&& roles.size()>0){
            for (Role role : roles) {
                sb.append(role.getRoleName()+",");
            }
        }
        //查询所有角色
        List<Role> roleList = roleService.findAll();
        //返回
        ModelAndView mv  = new ModelAndView();
        mv.setViewName("user-role-add");
        //存储数据-用户
        mv.addObject("user",sysUser);
        //存储数据-角色
        mv.addObject("roleList",roleList);
        //存储数据-用户所具有的角色
        mv.addObject("roleStr",sb.toString());
        return mv;
    }

    //用户详情
    @RequestMapping("/findById")
    public ModelAndView findById(Long id){
        System.out.println("史蒂芬地方"+id);
        //根据id 查询
       SysUser sysUser =  userService.findById(id);
       //返回
        System.out.println(sysUser.getRoles());
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",sysUser);
        mv.setViewName("user-show");
        return mv;
    }
    //保存用户
    @RequestMapping("/save")
    public String save(SysUser sysUser){
        userService.save(sysUser);
        return "redirect:/user/findAll";
    }

    //查询全部
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(required = true,defaultValue = "1") int pageNum,
            @RequestParam(required = true,defaultValue = "2") int pageSize
    ){
        //测试代码,在后台获取用户名
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User principal =(User) authentication.getPrincipal();
        System.out.println("登陆用户"+principal.getUsername());

        List<SysUser> userList = userService.findAll(pageNum,pageSize);
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pb",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }
}
