package com.lan.zz.povo;

import java.util.List;

public class LayuiTable {

    private Integer code;
    private String msg;
    private Long count;
    private List data;


    public LayuiTable(Integer code, String msg, Long count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public LayuiTable(Long count, List data) {
        code = 0;
        msg = "";
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiTable{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public void out() {
        System.out.println("code = " + code);
        System.out.println("msg = "+msg);
        System.out.println("count = " + count);
        System.out.println("data = ");
        for (Object zj : data) {
            System.out.println("\t" + zj.toString());
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public LayuiTable() {

    }
}
