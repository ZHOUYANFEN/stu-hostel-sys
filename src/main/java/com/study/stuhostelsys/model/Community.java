package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "community")
@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 公社公寓id

    @Column(name = "community_name")
    private String communityName; // 公社名

    @Column(name = "flat_name")
    private String flatName; // 公寓名

    @Column(name = "address")
    private String address; // 公寓地址

    @Column(name = "admin_id")
    private int adminId; // 管理员id

    @Column(name = "admin_name")
    private String adminName; // 管理员名称

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

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
