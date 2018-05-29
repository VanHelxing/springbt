package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统资源
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_resource")
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = -5647920440039366351L;
    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 功能名称
     */
    private String methodName;

    /**
     * 功能路径
     */
    private String methodpath;

    /**
     * 备注
     */
    private String remark;

    /** 角色资源 */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysResource")
    private Set<SysRoleResource> roleResources = new HashSet<>();


}
