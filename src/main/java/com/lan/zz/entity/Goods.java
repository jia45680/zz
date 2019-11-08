package com.lan.zz.entity;

import java.util.ArrayList;
import java.util.List;

public class Goods {

    //药品id
    private String gId;
    //票号
    private String ticket;
    //药品名称
    private String gName;
    //产地
    private String cd;
    //规格
    private String gg;
    //数量
    private Integer number;
    //批号
    private String ph;
    //生成日期
    private String scrq;
    //保质期
    private String yxq;
    //质检单路径
    private List<String> zjdPathList = new ArrayList<>();
    //批件路径
    private List<String> pjPathList = new ArrayList<>();

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getScrq() {
        return scrq;
    }

    public void setScrq(String scrq) {
        this.scrq = scrq;
    }

    public String getYxq() {
        return yxq;
    }

    public void setYxq(String yxq) {
        this.yxq = yxq;
    }

    public List<String> getZjdPathList() {
        return zjdPathList;
    }

    public List<String> getPjPathList() {
        return pjPathList;
    }

    public void setTx_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj1_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj2_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj3_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj4_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj5_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj6_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj7_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZj8_path(String path) {
        if (path != null && path.trim().length() != 0) zjdPathList.add(path);
    }

    public void setZz_path(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path1(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path2(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path3(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path4(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path5(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path6(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path7(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path8(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    public void setZz_path9(String path) {
        if (path != null && path.trim().length() != 0) pjPathList.add(path);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gId='" + gId + '\'' +
                ", ticket='" + ticket + '\'' +
                ", gName='" + gName + '\'' +
                ", cd='" + cd + '\'' +
                ", gg='" + gg + '\'' +
                ", number=" + number +
                ", ph='" + ph + '\'' +
                ", scrq='" + scrq + '\'' +
                ", yxq='" + yxq + '\'' +
                ", zjdPathList=" + zjdPathList +
                ", pjPathList=" + pjPathList +
                '}';
    }
}
