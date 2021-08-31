package com.njtech.blogadmin.service;

import com.njtech.blogadmin.entity.Admin;
import com.njtech.blogadmin.entity.Permission;

import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 13:24
 */
public interface AdminService {
    Admin findAdminByUserName(String username);

    List<Permission> getPermissionsByAdminId(Integer id);
}
