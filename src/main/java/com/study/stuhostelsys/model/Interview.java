package com.study.stuhostelsys.model;

import javax.persistence.*;

@Table(name = "interview")
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visit")
    private String visit;

    @Column(name = "visit_id")
    private String visitId;

    @Column(name = "visit_tel")
    private String visitTel;

    @Column(name = "flat_name")
    private String flatName;

    @Column(name = "flat_tel")
    private String flatTel;

    @Column(name = "flat_num")
    private String flatNum;

    @Column(name = "time")
    private String time;

    public Interview(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitTel() {
        return visitTel;
    }

    public void setVisitTel(String visitTel) {
        this.visitTel = visitTel;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getFlatTel() {
        return flatTel;
    }

    public void setFlatTel(String flatTel) {
        this.flatTel = flatTel;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
