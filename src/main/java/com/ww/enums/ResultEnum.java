package com.ww.enums;

/**
 *  状态码和提示信息对应的枚举
 * @author WangWei
 * @Title: ResultEnum
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 15:26
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
