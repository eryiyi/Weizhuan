package com.liangxunwang.unimanager.util;

import java.util.List;


public class DistrictCell {
    private String no;
    private String name;
    private List<DistrictCell> list;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DistrictCell> getList() {
        return list;
    }

    public void setList(List<DistrictCell> list) {
        this.list = list;
    }
}
