package com.ww.utils;

import com.ww.model.Gril;
import com.ww.model.Result;

/**
 *  返回结果的工具类
 * @author WangWei
 * @Title: ResultUtils
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 11:26
 */
public class ResultUtils {

    /**
     *  响应成功的方法
     * @param object
     * @return
     */
    public static Result<Gril> success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setDate(object);
        return result;
    }

    /**
     * 不返回数据的方法
     * @return
     */
    public static  Result<Gril> success() {
        return success(null);
    }
    /**
     *  响应失败的方法
     * @param code
     * @param msg
     * @return
     */
    public static Result<Gril> fail(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
