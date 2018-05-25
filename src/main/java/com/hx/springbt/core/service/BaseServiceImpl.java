package com.hx.springbt.core.service;

import com.hx.springbt.common.util.lang.StringUtils;
import com.hx.springbt.common.util.page.PageUtils;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.entity.PageInfo;
import com.hx.springbt.core.entity.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    /**
     * 分页查询(一个参数对应一个条件)
     *
     * @param params   参数信息
     * @param pageInfo 页面信息
     * @return the page
     * @author : yangjunqing / 2018-05-25
     */
    @Override
    public Page<T> search(List<SearchParam> params, PageInfo pageInfo) {

        Pageable pageable = PageUtils.buildPageRequest(pageInfo);

        Page<T> page = getRepository().findAll(new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();

//                predicates.add(builder.like(root.get("id").as(String.class),"%"));
                //遍历参数信息
                if (params != null && params.size() > 0) {
                    for (SearchParam param : params) {
                        String column = param.getColumnName();
                        Class<?> clazz = param.getClazz();
                        Object value = param.getColumnValue();
                        if ((!StringUtils.isEmpty(column)) && clazz != null && value != null) {
                            predicates.add(builder.like((Expression<String>) root.get(column).as(clazz), "%" + value + "%"));
                        }
                    }
                }

                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);

        return page;
    }

}
