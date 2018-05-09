package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "Serve")
@Entity
public class Serve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 服务id

    @Column(name = "flat_name")
    private String flatName; // 公寓

    @Column(name = "flat_address")
    private String flatAddress; // 公寓地址

    @Column(name = "flat_user")
    private String flatUser; // 住户姓名

    @Column(name = "flat_user_tel")
    private String flatUserTel; // 住户电话

    @Column(name = "type")
    private String type; // 服务类型

    @Column(name = "time")
    private String time; // 服务时间

    @Column(name = "status")
    private String status; // 服务状态

    @Column(name = "remark")
    private String remark; // 备注 - admin标记

    public Serve(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getFlatAddress() {
        return flatAddress;
    }

    public void setFlatAddress(String flatAddress) {
        this.flatAddress = flatAddress;
    }

    public String getFlatUser() {
        return flatUser;
    }

    public void setFlatUser(String flatUser) {
        this.flatUser = flatUser;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
