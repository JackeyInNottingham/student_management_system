package com.jackeyj.sms.common.utils;

import java.util.HashMap;

/**
 * 返回结果工具类
 * @author jiyaofei
 */
public class Result extends HashMap<String, Object> {

    public Result(){
        put("success", true);
        put("msg", "");
        put("code", "0");
    }

    public static Result success(){
        return new Result();
    }

    public static Result success(String msg){
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.put("success", false);
        return result;
    }

    public static Result fail(String errorMsg){
        Result result = new Result();
        result.put("success", false);
        result.put("msg", errorMsg);
        return result;
    }

    public static Result fail(String errorMsg, String code){
        Result result = new Result();
        result.put("success", false);
        result.put("msg", errorMsg);
        result.put("code", code);
        return result;
    }

    /**
     * 实现链式操作
     * @param key
     * @param value
     * @return
     */
    @Override
    public Result put(String key, Object value){
        super.put(key, value);
        return this;
    }
}
