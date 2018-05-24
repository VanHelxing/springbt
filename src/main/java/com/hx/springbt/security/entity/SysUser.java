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
 * 用户表
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 机构
     */
    private String orgId;

    /**
     * Email
     */
    private String email;

    /**
     * 联系电话
     */
    private String tel;

    /** 用户角色 */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysUser")
    private Set<SysUserRole> userRoles = new HashSet<SysUserRole>();


}
