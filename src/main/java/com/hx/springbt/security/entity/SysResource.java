package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统资源
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_resource")
public class SysResource extends BaseEntity {

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


}
