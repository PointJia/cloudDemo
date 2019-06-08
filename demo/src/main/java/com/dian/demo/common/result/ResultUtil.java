package com.dian.demo.common.result;

/**
 * 返回结果的工具类
 */
public class ResultUtil {

    public static Result success(Object data){
        return new Result(0,Result.SUCCESS_MSG,data);
    }

    public static Result success(){
        return success(null);
    }

    public static Result fail(){
        return new Result(1,Result.FAIL_MSG);
    }

}
