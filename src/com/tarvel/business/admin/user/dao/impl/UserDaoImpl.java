package com.tarvel.business.admin.user.dao.impl;

import com.tarvel.basic.page.Page;
import com.tarvel.business.admin.user.bo.User;
import com.tarvel.business.admin.user.dao.UserDao;
import com.tarvel.basic.dao.impl.BasicDaoImpl;
import com.tarvel.business.admin.user.po.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yuan on 2015/6/16 0016.
 */
@Repository("userDao")
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao {

    public UserEntity findUserByName(String userName) {
        String hql = " from UserEntity u where u.userName = :userName ";
        Query query = this.getSession().createQuery(hql);
        query.setString("userName", userName);
        return (UserEntity) query.list().get(0);
    }

    public Page<UserEntity> findUserList(User user, Serializable pageNum, Serializable pageSize) {
        String hql = " from UserEntity u where 1=1 ";
        String countHql = "select count(*) from UserEntity u where 1=1 ";
        Query query = this.getSession().createQuery(hql);
        Query countQuery = this.getSession().createQuery(countHql);
        query.setFirstResult(((Integer)pageNum));
        query.setMaxResults(((Integer) pageSize));
        return new Page<UserEntity>(countQuery.list().size(),query.list());
    }
}
