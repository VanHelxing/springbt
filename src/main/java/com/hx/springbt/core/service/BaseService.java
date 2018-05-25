package com.hx.springbt.core.service;

import com.hx.springbt.core.entity.PageInfo;
import com.hx.springbt.core.entity.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;


/**
 * 通用方法Service接口
 *
 * @param <T> the type parameter
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface BaseService<T> {


    /**
     * 保存
     *
     * @param s the s
     * @return t t
     * @author : yangjunqing / 2018-05-24
     */
    public T save(T s);


    /**
     * 删除
     *
     * @param s the s
     * @author : yangjunqing / 2018-05-24
     */
    public void delete(T s);

    /**
     * 查询单条信息
     *
     * @param id the id
     * @return t t
     * @author : yangjunqing / 2018-05-24
     */
    public T findById(String id);

    /**
     * 查询所有记录(不分页)
     *
     * @return list list
     * @author : yangjunqing / 2018-05-24
     */
    public List<T> findAll();

    /**
     * 查询所有记录(分页)
     *
     * @param pageable the pageable
     * @return page page
     * @author : yangjunqing / 2018-05-24
     */
    public Page<T> findAll(Pageable pageable);


    /**
     * 查询所有记录(用于复杂的sql查询，不分页)
     *
     * @param spec the spec
     * @return list list
     * @author : yangjunqing / 2018-05-24
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


    /**
     * 分页查询
     *
     * @param params 参数信息
     * @param pageInfo 页面信息
     * @return the page
     * @author : yangjunqing / 2018-05-25
     */
    public Page<T> search(List<SearchParam> params, PageInfo pageInfo);

}
