package com.hx.springbt.core.entity;

import java.util.Map;

/**
 * 响应的数据格式
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class PageData {

    /**
     * 页面信息
     */
    private Map<String, Object> pageInfo;

    /**
     * 数据
     */
    private Object data;


    public PageData(Map<String, Object> pageInfo, Object data) {
        this.pageInfo = pageInfo;
        this.data = data;
    }

    public Map<String, Object> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Map<String, Object> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
