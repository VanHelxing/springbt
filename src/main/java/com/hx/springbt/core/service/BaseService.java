package com.hx.springbt.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


/**
 * 通用方法Service接口
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface BaseService<T> {


    /**
     * 保存
     * @param s
     * @return
     */
    public T save(T s);


    /**
     * 删除
     * @param s
     */
    public void delete(T s);

    /**
     * 查询单条信息
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 查询所有记录(不分页)
     * @return
     */
    public List<T> findAll();

    /**
     * 查询所有记录(分页)
     * @param pageable
     * @return
     */
    public Page<T> findAll(Pageable pageable);


    /**
     * 查询所有记录(用于复杂的sql查询，不分页)
     * @param spec
     * @return
     */
    public List<T> findAll(Specification<T> spec);

    /**
     * 查询所有记录(用于复杂的sql查询，分页)
     *
     * @param spec     the spec
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    public Page<T> findAll(Specification<T> spec, Pageable pageable);

}
