package com.ww.exception;

import com.ww.enums.ResultEnum;

/**
 * @author WangWei
 * @Title: GrilException
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 14:51
 */
public class GrilException extends RuntimeException {

    /** 异常状态码 */
    public Integer code;

    public GrilException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
