package com.hx.springbt.core.entity;

import com.hx.springbt.core.config.UserIdAuditorAware;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
@EntityListeners(UserIdAuditorAware.class)
public class BaseEntity implements Serializable {

    /** 唯一ID */
    @Id
    @GenericGenerator(name = "twitter-id", strategy = "com.hx.springbt.core.entity.TwitterIdGennerate")
    @GeneratedValue(generator = "twitter-id")
    private String id;

    /** 创建用户 */
    @CreatedBy
    private String createId;

    /** 创建时间*/
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /** 最后一次修改用户*/
    @LastModifiedBy
    private String lastChangeId;

    /** 最后一次修改时间 */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeTime;

    /** 状态 */
    @Column(columnDefinition = "char(1) default '0'")
    private String status;

}
