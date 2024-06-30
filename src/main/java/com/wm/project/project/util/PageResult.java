package com.wm.project.project.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页查询返回结果实体类
 */
@Data
public class PageResult {
    public PageResult(PageInfo<?> pageInfo){
        code = 200;
        pageNum= pageInfo.getPageNum();
        pageSize = pageInfo.getPageSize();
        totalSize = pageInfo.getTotal();
        totalPages = pageInfo.getPages();
        data = pageInfo.getList();
    }
    /**
     * 状态码
     */
    private int code;
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> data;
}
