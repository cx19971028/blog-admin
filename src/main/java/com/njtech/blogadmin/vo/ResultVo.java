package com.njtech.blogadmin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenxin
 * @date 2021/8/31 10:29
 */
@Data
@AllArgsConstructor
public class ResultVo {
    private Boolean success;
    private int code;
    private String msg;
    private Object data;

    public static ResultVo success(Object data){
        return new ResultVo(true,200,"success",data);
    }

    public static ResultVo fail(int code, String msg){
        return new ResultVo(false,code,msg,null);
    }

}
