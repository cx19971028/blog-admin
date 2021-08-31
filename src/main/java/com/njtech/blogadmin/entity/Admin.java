package com.njtech.blogadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenxin
 * @date 2021/8/31 13:22
 */
@Data
public class Admin {
    // ID自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
