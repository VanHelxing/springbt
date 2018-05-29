package com.hx.springbt.core.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8075882163233196286L;


    /** 唯一ID */
    @Id
    @GenericGenerator(name = "twitter-id", strategy = "com.hx.springbt.core.entity.TwitterIdGennerate")
    @GeneratedValue(generator = "twitter-id")
    private String id;

    /** 创建用户 */
    @CreatedBy
    private String createBy;

    /** 创建时间*/
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /** 最后一次修改用户*/
    @LastModifiedBy
    private String lastmodifiedBy;

    /** 最后一次修改时间 */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifiedTime;

    /** 乐观锁 */
    @Version
    private Long version;

    /** 状态 */
    @Column(columnDefinition = "char(1) default '0'")
    private String status;

}
