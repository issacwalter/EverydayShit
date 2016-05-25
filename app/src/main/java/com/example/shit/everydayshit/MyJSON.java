package com.example.shit.everydayshit;

/**
 * Created by He on 2016/5/23.
 */

import com.alibaba.fastjson.JSONArray;

public class MyJSON {
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public JSONArray getTngou() {
        return tngou;
    }

    public void setTngou(JSONArray tngou) {
        this.tngou = tngou;
    }


    private boolean status;
    private int total;
    private JSONArray tngou;

    public MyJSON(boolean status, int total, JSONArray tngou) {
        super();
        this.status = status;
        this.total = total;
        this.tngou = tngou;
    }

    public MyJSON() {
    }

    @Override
    public String toString() {
        return "MyJSON [status=" + status + ", total=" + total + ", tngou=" + tngou + "]";
    }
}
