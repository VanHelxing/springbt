package com.hx.springbt.common.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "springbt_user")
public class User extends BaseEntity {

    /**
     * 用户编号
     */
    @Column(nullable = false, unique = true)
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别(0-男, 1-女, 2-不明)
     */
    @Column(columnDefinition = "char(1)")
    private String sexy;

    /**
     * 机构编号
     */
    private String orgId;

    /**
     * 部门编号
     */
    private String depId;

}
