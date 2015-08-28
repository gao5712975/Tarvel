package com.tarvel.business.admin.user.dao;


import com.tarvel.basic.dao.IBasicDao;
import com.tarvel.basic.page.Page;
import com.tarvel.business.admin.user.bo.User;
import com.tarvel.business.admin.user.po.UserEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yuan on 2015/6/16 0016.
 */
public interface UserDao extends IBasicDao<UserEntity> {

    UserEntity findUserByName(String userName);

    Page<UserEntity> findUserList(User user,Serializable pageNum,Serializable pageSize);
}
