package com.wm.project.project.util.page;

//import org.hibernate.validator.constraints.Range;

/**
 * 分页请求实体类
 */
public class PageRequest {
    /**
     * 当前页码，默认值是1
     */
    private int pageNum;
    /**
     * 每页数量,默认值是15
     */
//    @Range(min = 1,max = 100,message = "每页数量必须在1至100之间")
    private int pageSize;

    public int getPageNum() {
        return Math.max(pageNum, 1);
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if(pageSize<1){
            return 15;
        }else {
            return pageSize;
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
