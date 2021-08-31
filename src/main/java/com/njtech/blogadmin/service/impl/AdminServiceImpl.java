package com.njtech.blogadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.njtech.blogadmin.entity.Admin;
import com.njtech.blogadmin.entity.Permission;
import com.njtech.blogadmin.mapper.AdminMapper;
import com.njtech.blogadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 13:24
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByUserName(String username) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username).last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public List<Permission> getPermissionsByAdminId(Integer id) {

        return adminMapper.getPermissionsByAdminId(id);
    }
}
