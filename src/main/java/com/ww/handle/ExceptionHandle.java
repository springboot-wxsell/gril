package com.ww.handle;

import com.ww.exception.GrilException;
import com.ww.model.Result;
import com.ww.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获处理器
 * @author WangWei
 * @Title: ExceptionHandle
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 14:48
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GrilException) {
            return ResultUtils.fail(((GrilException) e).getCode(), e.getMessage());
        }else {
            log.error("[系统异常] {}", e);
            return ResultUtils.fail(-1, "未知错误!");
        }
    }
}
