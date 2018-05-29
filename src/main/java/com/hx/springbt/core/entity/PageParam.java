package com.hx.springbt.core.entity;

import com.hx.springbt.common.util.lang.StringUtils;

import java.util.List;

/**
 * 请求参数中的分页信息
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class PageParam {

    private final static int DEFAULT_PAGE_SIZE = 50;
    private final static int DEFAULT_PAGE_NUM = 1;
    private final static String DEFAULT_DIRECTION = "DESC";

    /** 当前页面 */
    private int pageNum;

    /** 页面大小 */
    private int pageSize;

    /** 排序(ASC, DESC) */
    private String direction;

    /** 排序的栏位信息 */
    private List<String> sorts;


    public PageParam() {
    }

    public PageParam(int pageNum, int pageSize, String direction, List<String> sorts) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.direction = direction;
        this.sorts = sorts;
    }

    public int getPageNum() {
        if (pageNum <= 0){
            pageNum = DEFAULT_PAGE_NUM;
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

    public String getDirection() {
        if (StringUtils.isEmpty(direction)){
            direction = DEFAULT_DIRECTION;
        }
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getSorts() {
        return sorts;
    }

    public void setSorts(List<String> sorts) {
        this.sorts = sorts;
    }
}
