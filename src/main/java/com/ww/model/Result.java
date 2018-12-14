package com.ww.model;

/**
 *  http请求放回最外层的对象
 * @author WangWei
 * @Title: Request
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 11:21
 */
public class Result<T> {

    /** 错误码 */
    private Integer code; // 0 失败，1 成功

    /** 提示信息 */
    private String msg;

    /** 返回数据 */
    private T date;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
