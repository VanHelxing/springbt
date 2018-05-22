package com.hx.springbt.core.service;

import com.hx.springbt.core.dao.BaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    abstract protected BaseDao<T> getRepository();

    /**
     * 保存
     *
     * @param s
     * @return
     */
    @Override
    public T save(T s) {
        return getRepository().save(s);
    }

    /**
     * 删除
     *
     * @param s
     */
    @Override
    public void delete(T s) {
        getRepository().delete(s);
    }

    /**
     * 查询单条信息
     *
     * @param id
     * @return
     */
    @Override
    public T findById(String id) {
        return (T) getRepository().findById(id);
    }

    /**
     * 查询所有记录(不分页)
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    /**
     * 查询所有记录(分页)
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    /**
     * 查询所有记录(用于复杂的sql查询，不分页)
     *
     * @param spec
     * @return
     */
    @Override
    public List<T> findAll(Specification<T> spec) {
        return getRepository().findAll(spec);
    }

    /**
     * 查询所有记录(用于复杂的sql查询，分页)
     *
     * @param spec     the spec
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return getRepository().findAll(spec, pageable);
    }
}
