package com.hx.springbt.system.entity.dict;

import com.hx.springbt.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字典明细
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "sys_dict_detail")
public class DictDetail extends BaseEntity {

    /** 字典类型 */
    private String dictType;

    /** 节点名 */
    private String treeName;

    /** 节点值 */
    private String treeValue;

    /** 节点代码 */
    private String treeCode;

    /** 优先级 */
    private Integer treeLevel;

    /** 备注 */
    private String remark;
}
