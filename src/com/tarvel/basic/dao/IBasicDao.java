package com.tarvel.basic.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Dao层接口
 * Created by Yuan on 2015/6/2.
 */
public interface IBasicDao<T> {

    void saveEntity(T entity);

    T getEntityById(Serializable id);

    void updateEntity(T entity);

    void deleteEntity(Serializable id);

    void deleteEntity(T enrity);
}
