package com.example.sbspring.Tool;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;
    private String token;

    public Result(T data) {
        this.data=data;
    }
    public Result() {
    }

    public static <T> Result<T> success(T data,String msg){
        Result<T> result=new Result<>(data);
        result.setCode("200");
        result.setMsg(msg);
        return result;
    }
    public static <T> Result<T> sgs(T data,String msg,String token){
        Result<T> result=new Result<>(data);
        result.setCode("200");
        result.setMsg(msg);
        result.setToken(token);
        return result;
    }

}
