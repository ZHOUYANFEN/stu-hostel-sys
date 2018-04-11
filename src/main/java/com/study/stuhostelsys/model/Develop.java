package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "develop")
@Entity
public class Develop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 第三方id

    @Column(name = "dev_name")
    private String devName; // 第三方名字

    @Column(name = "url")
    private String url; // 第三方URL

    @Column(name = "remark")
    private String remark; // 备注

    public Develop(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
