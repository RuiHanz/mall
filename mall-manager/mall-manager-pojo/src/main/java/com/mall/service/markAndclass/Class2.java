package com.mall.service.markAndclass;

public class Class2 {
    private Integer flmch2_id;
    private String  flmch2;

    public Class2() {
    }

    public Class2(Integer flmch2_id, String flmch2) {
        this.flmch2_id = flmch2_id;
        this.flmch2 = flmch2;
    }

    public Integer getFlmch2_id() {
        return flmch2_id;
    }

    public void setFlmch2_id(Integer flmch2_id) {
        this.flmch2_id = flmch2_id;
    }

    public String getFlmch2() {
        return flmch2;
    }

    public void setFlmch2(String flmch2) {
        this.flmch2 = flmch2;
    }

    @Override
    public String toString() {
        return "Class2{" +
                "flmch2_id=" + flmch2_id +
                ", flmch2='" + flmch2 + '\'' +
                '}';
    }
}
