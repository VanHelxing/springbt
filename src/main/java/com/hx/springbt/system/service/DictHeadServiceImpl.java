package com.hx.springbt.system.service;

import com.hx.springbt.system.dao.DictHeadDao;
import com.hx.springbt.system.entity.DictHead;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class DictHeadServiceImpl extends BaseServiceImpl<DictHead> implements DictHeadService {

    @Resource
    private DictHeadDao dictHeadDao;


    @Override
    protected BaseDao<DictHead> getRepository() {
        return dictHeadDao;
    }
    }