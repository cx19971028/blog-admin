package com.njtech.blogadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njtech.blogadmin.entity.Admin;
import com.njtech.blogadmin.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 13:27
 */
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("SELECT * FROM ms_permission where id in (select permission_id from ms_admin_permission where admin_id=#{AdminId})")
    List<Permission> getPermissionsByAdminId(Integer AdminId);
}
