package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "admin")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 管理员id

    @Column(name = "user_name")
    private String userName; // 管理员用户名

    @Column(name = "user_password")
    private String userPassword; // 管理员密码

    @Column(name = "power")
    private String power; // 管理员权限：

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
