package com.tarvel.business.admin.user.service;


import com.tarvel.basic.page.Page;
import com.tarvel.basic.service.IBasicService;
import com.tarvel.business.admin.user.bo.User;
import com.tarvel.business.admin.user.po.UserEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yuan on 2015/6/16 0016.
 */
public interface UserService extends IBasicService {
    void saveUser(User user);

    UserEntity findUserById(String userId);

    UserEntity findUserByName(String userName);

    Page<UserEntity> findUserList(User user,Serializable pageNum,Serializable pageSize);

    void insertUser(User user);

    void deleteUser(String userId);

    void updateUser(User user);
}
