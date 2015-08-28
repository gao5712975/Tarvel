package com.tarvel.shiro.session;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 登录用户
 *
 * @author liujiegang
 */
public class LoginUser implements Serializable {
    private String userId;
    private String userName;
    private String password;
    private Timestamp createTime;
    private String createUser;
    private Timestamp updateTime;
    private String updateUser;
    private String departCode;
    private String rootDepartCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getRootDepartCode() {
        return rootDepartCode;
    }

    public void setRootDepartCode(String rootDepartCode) {
        this.rootDepartCode = rootDepartCode;
    }
}
