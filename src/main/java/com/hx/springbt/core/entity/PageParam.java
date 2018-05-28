package com.hx.springbt.core.entity;

/**
 * 分页信息
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class PageParam {

    private final static int DEFAULT_PAGE_SIZE = 50;

    /** 当前页面 */
    private int pageNum;

    /** 页面大小 */
    private int pageSize;

    /** 排序列名 */
    private String sort;

    /** 排序方式 (ASC or DESC) */
    private String direction;


    public int getPageNum() {
        if (pageNum <= 0){
            pageNum = 1;
        }

        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (pageSize <= 0){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
