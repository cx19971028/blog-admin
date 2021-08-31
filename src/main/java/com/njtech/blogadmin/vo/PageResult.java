package com.njtech.blogadmin.vo;

import com.njtech.blogadmin.entity.Permission;
import lombok.Data;

import java.util.List;

/**
 * @author chenxin
 * @date 2021/8/31 11:50
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> list;
}
