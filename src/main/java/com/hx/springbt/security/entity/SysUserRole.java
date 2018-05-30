package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户角色表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = -4459080995201317505L;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SysRole.class)
    @JoinColumn(name = "role_id")
    private SysRole sysRole;

    /**
     * 机构编号
     */
    private String orgId;
}
