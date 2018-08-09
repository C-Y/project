package com.it.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.dao.IUserDao;
import com.it.domain.Role;
import com.it.domain.SysUser;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")//和spring-security配置文件中的对应
public class UserServiceImpl implements IUserService {
    //注入dao
    @Autowired
    private IUserDao userDao;
    //注入加密器
    @Autowired
    private PasswordEncoder passwordEncoder;

    //保存角色修改
    @Override
    public void addRoleToUser(Long userId, Long[] ids) {
        //先删除用户的角色
        userDao.deleteUserRoleByUserId(userId);
        //再给用户添加新角色
        if (ids.length > 0 && ids != null) {
            for (Long roleId : ids) {
                userDao.saveUserRole(userId,roleId);
            }
        }
    }

    //查询用户
    @Override
    public SysUser toUserRole(Long id) {
        return userDao.findById(id);
    }

    //用户详情
    @Override
    public SysUser findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void save(SysUser sysUser) {
        //对用户输入的密码进行加密
        String pwd = passwordEncoder.encode(sysUser.getPassword());
        //设置到用户对象中
        sysUser.setPassword(pwd);
        //保存
        userDao.save(sysUser);
    }

    @Override
    public List<SysUser> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.findAll();
    }


    @Override
    /*此方法由SpringSecurity框架调用，最终实现登陆认证
        参数：username 用户输入的用户名*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名,查询
        SysUser sysUser = userDao.findByUsername(username);
        /*//用户所有的角色权限(写死)
        List<GrantedAuthority> authorities = new ArrayList<>();
        //每个用户都有ROLE_USER角色,与Spring-security.xml中配置一致
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        //返回结果
        //import org.springframework.security.core.userdetails.User
        User user = new User(sysUser.getUsername(),sysUser.getPassword(),authorities)*/
        ;
        //根据用户查询获取角色
        if (sysUser != null) {
            //查询获取用户角色
            List<Role> roles = sysUser.getRoles();
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (roles != null && roles.size() > 0) {
                for (Role role : roles) {
                    //添加用户角色
                    authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                }
            }
            //返回结果
            User user = new User(username, sysUser.getPassword(), authorities);
            return user;
        }
        return null;
    }


}
