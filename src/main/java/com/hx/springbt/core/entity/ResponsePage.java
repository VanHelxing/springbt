package com.hx.springbt.core.entity;

import java.util.Map;

/**
 * 统一规范响应的数据格式(分页)
 */
public class ResponsePage {

    /**
     * 状态
     * <ul>
     *     <li>ok - 成功</li>
     *     <li>authentication failed - 认证失败</li>
     *     <li>fail - 已知错误</li>
     *     <li>system error - 系统异常</li>
     * </ul>
     */
    private String status;

    /**
     * 信息
     */
    private String message;

    /**
     * 页面信息
     */
    private Map<String, Object> pageInfo;

    /**
     * 数据
     */
    private Object data;

    public ResponsePage(String status, String message, Map<String, Object> pageInfo, Object data) {
        this.status = status;
        this.message = message;
        this.pageInfo = pageInfo;
        this.data = data;
    }

    public static ResponsePage ok(Object data, Map<String, Object> pageMap){
        return new ResponsePage("ok", "success", pageMap, data);
    }

    public static ResponsePage fail(){
        return new ResponsePage("fail", "fail", null, null);
    }

    public static ResponsePage fail(String message){
        return new ResponsePage("fail", message, null, null);
    }

    public static ResponsePage authFailed(){
        return new ResponsePage("authentication failed", "用户名或密码不正确!", null, null);
    }

    public static ResponsePage error(){
        return new ResponsePage("system error", "系统发生了异常,请稍后再试！", null, null);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
