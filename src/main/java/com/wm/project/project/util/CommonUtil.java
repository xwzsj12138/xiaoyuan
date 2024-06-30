package com.wm.project.project.util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 常用工具类
 */
public class CommonUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 返回状态码为200的json
     *
     * @return 返回result实体
     */
    public static Result<Object> successResult() {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }

    /**
     * 返回一个带有数据的返回状态码为200的json
     *
     * @param data 具体数据
     * @return 返回result实体
     */
    public static Result<Object> successResult(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setTimestamp(sdf.format(new Date()));
        result.setData(data);
        return result;
    }

    /**
     * 默认返回操作错误
     * @return
     */

    public static Result<Object> errorResult() {
        Result<Object> result = new Result<>();
        result.setCode(-200);
        result.setMsg("操作失败");
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }

    /**
     * 返回一个带有错误信息码的json
     *
     * @param errorEnum 错误信息类型
     * @return 返回result实体
     */

    public static Result<Object> errorResult(String msg){
        Result<Object> result = new Result<>();
        result.setCode(-200);
        result.setMsg(msg);
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }


}
