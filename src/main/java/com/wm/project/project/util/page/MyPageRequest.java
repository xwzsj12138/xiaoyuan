package com.wm.project.project.util.page;

//import org.hibernate.validator.constraints.Range;

/**
 * 分页请求实体类,因为PageRequest里面的属性名会被自动识别然后进行分页，重新写一个属性名不一样的，防止被自动分页
 */
public class MyPageRequest {
    /**
     * 当前页码，默认值是1
     */
    private int myPageNum;
    /**
     * 每页数量,默认值是15
     */
//    @Range(min = 1,max = 100,message = "每页数量必须在1至100之间")
    private int myPageSize;

    public int getMyPageNum() {
        return Math.max(myPageNum, 1);
    }

    public void setMyPageNum(int pageNum) {
        this.myPageNum = pageNum;
    }

    public int getMyPageSize() {
        if(myPageSize<1){
            return 15;
        }else {
            return myPageSize;
        }
    }

    public void setMyPageSize(int pageSize) {
        this.myPageSize = pageSize;
    }
}
