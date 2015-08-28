package com.tarvel.business.admin.user.enums;

import javax.persistence.Entity;

/**
 * 用户类型
 *
 * @author luffy
 * @date 15/5/6
 */
@Entity
public enum UserType {

    system("系统账户"),
    member("会员"),
    parkingManager("收费员"),
    parkingOwner("管理主体"),
    parkingRevisit("踏勘员");

    UserType(String desc) {
        this.desc = desc;
    }
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
