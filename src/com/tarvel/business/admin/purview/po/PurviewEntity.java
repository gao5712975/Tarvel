package com.tarvel.business.admin.purview.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Yuan on 2015/7/13 0013.
 */
@Entity
@Table(name = "t_purview")
public class PurviewEntity {
    private String purviewId;
    private String purviewName;
    private String purviewUrl;
    private String parentId;
    private String purviewType;
    private Integer purviewOrder;
    private String departCode;
    private String rootDepartCode;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private String purviewImg;
    private String isMenu;

    @Id
    @Column(name = "purview_id")
    @GeneratedValue(generator = "purviewGenerator")
    @GenericGenerator(name = "purviewGenerator", strategy = "uuid")
    public String getPurviewId() {
        return purviewId;
    }

    public void setPurviewId(String purviewId) {
        this.purviewId = purviewId;
    }

    @Basic
    @Column(name = "purview_name")
    public String getPurviewName() {
        return purviewName;
    }

    public void setPurviewName(String purviewName) {
        this.purviewName = purviewName;
    }

    @Basic
    @Column(name = "purview_url")
    public String getPurviewUrl() {
        return purviewUrl;
    }

    public void setPurviewUrl(String purviewUrl) {
        this.purviewUrl = purviewUrl;
    }

    @Basic
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "purview_type")
    public String getPurviewType() {
        return purviewType;
    }

    public void setPurviewType(String purviewType) {
        this.purviewType = purviewType;
    }

    @Basic
    @Column(name = "purview_order")
    public Integer getPurviewOrder() {
        return purviewOrder;
    }

    public void setPurviewOrder(Integer purviewOrder) {
        this.purviewOrder = purviewOrder;
    }

    @Basic
    @Column(name = "depart_code")
    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    @Basic
    @Column(name = "root_depart_code")
    public String getRootDepartCode() {
        return rootDepartCode;
    }

    public void setRootDepartCode(String rootDepartCode) {
        this.rootDepartCode = rootDepartCode;
    }

    @Basic
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_user")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "purview_img")
    public String getPurviewImg() {
        return purviewImg;
    }

    public void setPurviewImg(String purviewImg) {
        this.purviewImg = purviewImg;
    }

    @Basic
    @Column(name = "is_menu")
    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }
}
