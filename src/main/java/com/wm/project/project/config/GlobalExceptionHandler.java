package com.wm.project.project.config;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyf
 * @since 2022/3/14 10:30
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 拦截自定义异常
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public Result<Object> commonExceptionHandler(CommonException commonException) {
        return commonException.getResult();
    }
}
