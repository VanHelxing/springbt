package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色资源映射表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_role_resource")
public class SysRoleResource extends BaseEntity {

    /**
     * 资源编号
     */
    private String resourceId;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 机构编号
     */
    private String orgId;
}
