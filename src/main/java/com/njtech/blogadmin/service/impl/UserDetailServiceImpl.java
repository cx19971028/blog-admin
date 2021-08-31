package com.njtech.blogadmin.service.impl;

import com.njtech.blogadmin.entity.Admin;
import com.njtech.blogadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 13:20
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 当用户登录的时候，springSecurity 就会将请求 转发到此
        // 根据用户名 查找用户，不存在 抛出异常，存在 将用户名，密码，授权列表 组装成springSecurity的User对象 并返回
        Admin admin = adminService.findAdminByUserName(username);
        if(admin==null){
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // security会自动根据配置的加密算法认证密码
        UserDetails userDetails = new User(username, admin.getPassword(), authorityList);
        return userDetails;
    }
}
