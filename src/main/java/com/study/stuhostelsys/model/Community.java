package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "community")
@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 公社id

    @Column(name = "community_name")
    private String communityName; // 公社名

    @Column(name = "address")
    private String address; // 公社地址

    @Column(name = "admin_id")
    private int adminId; // 管理员id

    @Column(name = "remark")
    private String remark; // 备注

    public Community() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
