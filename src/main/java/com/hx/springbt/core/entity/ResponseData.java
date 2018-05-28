package com.hx.springbt.core.entity;

import java.io.Serializable;

/**
 * 统一规范响应的数据格式
 */
public class ResponseData implements Serializable {

    /**
     * code
     * <ul>
     *     <li>0000 - 成功</li>
     *     <li>0001- 认证失败</li>
     *     <li>9998 - 已知错误</li>
     *     <li>9999 - 系统异常</li>
     * </ul>
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private PageData pageData;


    public ResponseData() {
    }

    public ResponseData(String code, String message, PageData pageData) {
        this.code = code;
        this.message = message;
        this.pageData = pageData;
    }

    public static ResponseData ok(PageData pageData){
        return new ResponseData("0000", "success", pageData);
    }

    public static ResponseData authFail(){
        return new ResponseData("0001", "authentication failure!", null);
    }

    public static ResponseData fail(String message){
        return new ResponseData("9998", message, null);
    }

    public static ResponseData error(){
        return new ResponseData("9999", "system error!", null);
    }
}
