package com.njtech.blogadmin.service.impl;

import com.njtech.blogadmin.entity.Admin;
import com.njtech.blogadmin.entity.Permission;
import com.njtech.blogadmin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 14:55
 */
@Service
public class AuthService {

    @Autowired
    private AdminService adminService;

    /**
     * 权限认证
     * @param request
     * @param authentication
     * @return
     */
    public boolean auth(HttpServletRequest request, Authentication authentication){
        // 获取访问路径
        String requestURI = request.getRequestURI();
        // 过去带参数的uri
        String uri = StringUtils.split(requestURI, "?")[0];
        // 获取authentication中的UserDetail对象
        Object principal = authentication.getPrincipal();
        // 对象不存在或者是匿名用户
        if(principal==null||"anonymousUser".equals(principal)){
            return false;
        }
        User user = (User) principal;
        String username = user.getUsername();
        Admin admin = adminService.findAdminByUserName(username);
        if(admin==null){
            return false;
        }
        Integer AdminId = admin.getId();
        if(AdminId==1){
            // 超级管理员
            return true;
        }

        // 根据当前登录的用户获取其所有的权限列表
        List<Permission> permissionList = adminService.getPermissionsByAdminId(AdminId);
        for (Permission permission : permissionList) {
            if(uri.equals(permission.getPath())){
                return true;
            }
        }
        return false;
    }
}
