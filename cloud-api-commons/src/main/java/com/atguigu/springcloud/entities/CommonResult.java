package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{
    private int code;
    private String msg;
    private T data;

    public static <T> CommonResult<T> ok(T data){
        return new CommonResult<T>(200, "success", data);
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(200, "success", data);
    }
}
