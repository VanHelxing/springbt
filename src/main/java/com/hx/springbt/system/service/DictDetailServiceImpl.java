package com.hx.springbt.system.service;

import com.hx.springbt.system.dao.DictDetailDao;
import com.hx.springbt.system.entity.DictDetail;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class DictDetailServiceImpl extends BaseServiceImpl<DictDetail> implements DictDetailService {

    @Resource
    private DictDetailDao dictDetailDao;


    @Override
    protected BaseDao<DictDetail> getRepository() {
        return dictDetailDao;
    }
    }