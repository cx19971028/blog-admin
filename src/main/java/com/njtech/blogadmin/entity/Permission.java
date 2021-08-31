package com.njtech.blogadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenxin
 * @date 2021/8/31 11:02
 */
@Data
public class Permission {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String path;
    private String description;
}
