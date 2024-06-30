package com.wm.project.project.config;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Result;


/**
 * @author zyf
 * @since 2022/3/14 10:40
 */

public class CommonException  extends  RuntimeException{
    final Result<Object> result;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     */
    public CommonException(Result<Object> result){
        this.result = result;
    }

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     */
    public CommonException(String msg){
        this.result = CommonUtil.errorResult(msg);
    }

    public Result<Object> getResult(){
        return result;
    }
}
