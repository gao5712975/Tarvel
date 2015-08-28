package com.tarvel.basic.dao.impl;

import com.tarvel.basic.dao.IBasicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基础Dao层实现
 * Created by Yuan on 2015/6/2.
 */
@Repository("basicDao")
public class BasicDaoImpl<T> implements IBasicDao<T> {

    private SessionFactory sessionFactory;
    private Class<T> persistentClass;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public Class<T> getPersistentClass() {
        if (persistentClass == null) {
            persistentClass = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        return persistentClass;
    }

    public void saveEntity(T entity) {
        this.getSession().save(entity);
    }

    @SuppressWarnings("unchecked")
    public T getEntityById(Serializable id) {
        return (T) this.getSession().load(getPersistentClass(), id);
    }

    public void updateEntity(T entity) {
        this.getSession().update(entity);
    }

    public void deleteEntity(Serializable id) {
        this.getSession().delete(this.getEntityById(id));
    }

    public void deleteEntity(T enrity) {
        this.getSession().delete(enrity);
    }
}
