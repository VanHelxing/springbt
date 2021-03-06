package com.hx.springbt.security.entity;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = -2867090270310549565L;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 机构
     */
    private String orgId;
}
