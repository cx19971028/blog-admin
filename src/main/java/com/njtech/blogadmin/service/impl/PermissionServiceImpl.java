package com.njtech.blogadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njtech.blogadmin.entity.Permission;
import com.njtech.blogadmin.mapper.PermissionMapper;
import com.njtech.blogadmin.service.PermissionService;
import com.njtech.blogadmin.vo.PageResult;
import com.njtech.blogadmin.vo.ResultVo;
import com.njtech.blogadmin.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxin
 * @date 2021/8/31 10:47
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public ResultVo getPermissionList(PageParam pageParam) {
        // 分页
        Page<Permission> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        if(pageParam.getQueryString()!=null){
            queryWrapper.eq(Permission::getName,pageParam.getQueryString());
        }
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> permissionPageResult = new PageResult<>();
        permissionPageResult.setTotal(permissionPage.getTotal());
        permissionPageResult.setList(permissionPage.getRecords());
        return ResultVo.success(permissionPageResult);
    }

    @Override
    public ResultVo addPermission(Permission permission) {
        permissionMapper.insert(permission);
        return ResultVo.success(null);
    }

    @Override
    public ResultVo updatePermission(Permission permission) {
        permissionMapper.updateById(permission);
        return ResultVo.success(null);
    }

    @Override
    public ResultVo deleteById(Integer id) {
        permissionMapper.deleteById(id);
        return ResultVo.success(null);
    }
}
