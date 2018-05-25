package com.hx.springbt.core.entity;

import lombok.Data;

/**
 * 查询参数
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
public class SearchParam {

    /**
     * 参数列名
     */
    private String columnName;

    /**
     * 数据类型
     */
    private Class<?> clazz;

    /**
     * 值
     */
    private Object columnValue;

}
