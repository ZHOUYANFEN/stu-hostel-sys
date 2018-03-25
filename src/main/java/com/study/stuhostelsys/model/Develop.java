package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "Develop")
@Entity
public class Develop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 第三方id
    private String dev_name; // 第三方名字
    private String url; // 第三方URL
    private String remark; // 备注

    public Develop(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
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
