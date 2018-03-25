package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "Serve")
@Entity
public class Serve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 服务id
    private String flat_name; // 公寓名
    private String flat_user; // 住户姓名
    private String flat_user_id; // 住户身份证
    private String flat_user_tel; // 住户电话
    private String type; // 服务类型
    private String money; // 金额
    private String remark; // 备注 - admin标记

    public Serve(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlat_name() {
        return flat_name;
    }

    public void setFlat_name(String flat_name) {
        this.flat_name = flat_name;
    }

    public String getFlat_user() {
        return flat_user;
    }

    public void setFlat_user(String flat_user) {
        this.flat_user = flat_user;
    }

    public String getFlat_user_id() {
        return flat_user_id;
    }

    public void setFlat_user_id(String flat_user_id) {
        this.flat_user_id = flat_user_id;
    }

    public String getFlat_user_tel() {
        return flat_user_tel;
    }

    public void setFlat_user_tel(String flat_user_tel) {
        this.flat_user_tel = flat_user_tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
