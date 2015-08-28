package com.tarvel.shiro.session;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by mac on 15/3/12.
 */
public class ShiroSessionManage {

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static LoginUser getLoginUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null && currentUser.isAuthenticated()) { // 判断是否通过验证
            return (LoginUser) currentUser.getPrincipal();
        }
        return null;
    }




    /**
     * 登出
     */
    public static void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null)
            currentUser.logout();
    }
}
