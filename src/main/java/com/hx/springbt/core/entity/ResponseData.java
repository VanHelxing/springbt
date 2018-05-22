package com.hx.springbt.core.entity;

/**
 * 统一规范响应的数据格式
 */
public class ResponseData {

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
     * 数据
     */
    private Object data;


    private ResponseData(){

    }

    public ResponseData(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseData ok(Object data){
        return new ResponseData("ok", "success", data);
    }

    public static ResponseData fail(){
        return new ResponseData("fail", "fail", null);
    }

    public static ResponseData fail(String message){
        return new ResponseData("fail", message, null);
    }

    public static ResponseData authFailed(){
        return new ResponseData("authentication failed", "用户名或密码不正确!", null);
    }

    public static ResponseData error(){
        return new ResponseData("system error", "系统发生了异常,请稍后再试！", null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
