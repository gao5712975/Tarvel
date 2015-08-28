package com.tarvel.shiro.service;

import com.tarvel.business.admin.user.po.UserEntity;
import com.tarvel.business.admin.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Shiro与系统的业务层
 *
 * @author liujiegang
 */
@Service("shiroService")
public class ShiroService {
    @Resource
    private UserService userService;

    public UserEntity findUserByName(String userName){
        return userService.findUserByName(userName);
    }
}
