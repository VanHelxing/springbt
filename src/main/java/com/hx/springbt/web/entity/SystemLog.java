package com.hx.springbt.web.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统日志
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "system_log")
@DynamicInsert
@DynamicUpdate
public class SystemLog extends BaseEntity {

    /**
     * 访问类型(system, api)
     */
    private String requestType;

    /**
     * 请求路径
     */
    private String requestUri;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求地址
     */
    private String requestAddr;

    /**
     * 响应状态
     */
    private String ResponseStatus;

    /**
     * 响应数据
     */
    private String ResponseData;

    /**
     * 处理时间
     */
    private String handleTime;

}
