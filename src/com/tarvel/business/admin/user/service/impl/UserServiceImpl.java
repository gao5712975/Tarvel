package com.tarvel.business.admin.user.service.impl;

import com.tarvel.basic.page.Page;
import com.tarvel.basic.service.impl.BasicServiceImpl;
import com.tarvel.business.admin.user.bo.User;
import com.tarvel.business.admin.user.dao.UserDao;
import com.tarvel.business.admin.user.po.UserDetailEntity;
import com.tarvel.business.admin.user.po.UserEntity;
import com.tarvel.business.admin.user.service.UserService;
import com.tarvel.util.MD5.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Yuan on 2015/6/3.
 */
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.saveEntity(this.convertBusinessValue(user, UserEntity.class));
    }

    public UserEntity findUserById(String userId) {
        return userDao.getEntityById(userId);
    }

    public UserEntity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    public Page<UserEntity> findUserList(User user, Serializable pageNum, Serializable pageSize) {
        return userDao.findUserList(user,pageNum,pageSize);
    }

    public void insertUser(User user) {
        UserEntity entity = this.convertBusinessValue(user, UserEntity.class);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        if (entity.getUserPassword() == null) {
            entity.setUserPassword(MD5Util.getPasswordWithMD5("123456"));
        }else{
            entity.setUserPassword(MD5Util.getPasswordWithMD5(entity.getUserPassword()));
        }
        entity.setValid("0");
        UserDetailEntity detailEntity = this.convertBusinessValue(user, UserDetailEntity.class);
        detailEntity.setUser(entity);
        entity.setUserDetail(detailEntity);
        userDao.saveEntity(entity);
    }

    public void deleteUser(String userId) {
        userDao.deleteEntity(userId);
    }

    public void updateUser(User user) {
        UserEntity entity =  userDao.getEntityById(user.getUserId());
        if(entity != null){
            entity.setUserName(user.getUserName());
            entity.setUpdateUser(user.getUpdateUser());
            entity.setUpdateTime(new Date());
//            if(!entity.getDepartCode().equals(user.getDepartCode())) {
//                entity.setDepartCode(user.getDepartCode());
//            }
            UserDetailEntity userDetail = this.convertBusinessValue(user, entity.getUserDetail());
            userDetail.setUser(entity);
            entity.setUserDetail(userDetail);
        }
        userDao.updateEntity(entity);
    }
}
