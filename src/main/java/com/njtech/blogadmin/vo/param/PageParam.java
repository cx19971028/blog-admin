package com.njtech.blogadmin.vo.param;

import lombok.Data;

/**
 * @author chenxin
 * @date 2021/8/31 10:43
 */
@Data
public class PageParam {
    private int currentPage;
    private int pageSize;
    private String queryString;
}
