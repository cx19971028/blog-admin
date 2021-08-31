package com.njtech.blogadmin.service;

import com.njtech.blogadmin.entity.Permission;
import com.njtech.blogadmin.vo.ResultVo;
import com.njtech.blogadmin.vo.param.PageParam;

/**
 * @author chenxin
 * @date 2021/8/31 10:47
 */
public interface PermissionService {

    ResultVo getPermissionList(PageParam pageParam);

    ResultVo addPermission(Permission permission);

    ResultVo updatePermission(Permission permission);

    ResultVo deleteById(Integer id);
}
