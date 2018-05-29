package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 角色资源映射表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_role_resource")
public class SysRoleResource extends BaseEntity {

    private static final long serialVersionUID = -27860623274181706L;

    /**
     * 资源
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysResource.class)
    @JoinColumn(name = "resource_id", nullable = false)
    private SysResource sysResource;

    /**
     * 角色
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysRole.class)
    @JoinColumn(name = "role_id", nullable = false)
    private SysRole sysRole;

    /**
     * 机构编号
     */
    private String orgId;
}
