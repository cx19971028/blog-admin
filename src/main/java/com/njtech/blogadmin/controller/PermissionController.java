package com.njtech.blogadmin.controller;

import com.njtech.blogadmin.entity.Permission;
import com.njtech.blogadmin.service.PermissionService;
import com.njtech.blogadmin.vo.ResultVo;
import com.njtech.blogadmin.vo.param.PageParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenxin
 * @date 2021/8/31 10:36
 */
@RestController
@RequestMapping("/admin/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permissionList")
    public ResultVo getPermissionList(@RequestBody PageParam pageParam){
        return permissionService.getPermissionList(pageParam);
    }

    @PostMapping("/add")
    public ResultVo addPermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @PostMapping("/update")
    public ResultVo updatePermission(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }

    @GetMapping("/delete/{id}")
    public ResultVo deleteById(@PathVariable("id") Integer id){
        return permissionService.deleteById(id);
    }

}
