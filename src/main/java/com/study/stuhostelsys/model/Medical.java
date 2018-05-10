package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "medical")
@Entity
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_tel")
    private String userTel;
    @Column(name = "allergy")
    private String allergy;
    @Column(name = "me_history")
    private String meHistory;

    public Medical() {

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getMeHistory() {
        return meHistory;
    }

    public void setMeHistory(String meHistory) {
        this.meHistory = meHistory;
    }
}
