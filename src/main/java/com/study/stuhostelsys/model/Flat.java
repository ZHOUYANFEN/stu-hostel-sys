package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "flat")
@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "flat_name")
    private String flatName;

    @Column(name = "flat_num")
    private String flatNum;

    @Column(name = "falt_user")
    private String flatUser;

    @Column(name = "falt_user_id")
    private String flatUserId;

    @Column(name = "falt_user_tel")
    private String flatUserTel;

    @Column(name = "type")
    private String type;

    @Column(name = "remark")
    private String remark;

    public Flat(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getFlatUser() {
        return flatUser;
    }

    public void setFlatUser(String flatUser) {
        this.flatUser = flatUser;
    }

    public String getFlatUserId() {
        return flatUserId;
    }

    public void setFlatUserId(String flatUserId) {
        this.flatUserId = flatUserId;
    }

    public String getFlatUserTel() {
        return flatUserTel;
    }

    public void setFlatUserTel(String flatUserTel) {
        this.flatUserTel = flatUserTel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
