package com.mall.service;

public class Order {
    private String dd_id;
    private String yh_id;
    private String chjshj;
    private Float jze;
    private String shhr;
    private Integer jdh;
    private String yjsdsj;
    private String dzh_mch;

    public Order() {
    }

    public Order(String dd_id, String yh_id, String chjshj, Float jze, String shhr, Integer jdh, String yjsdsj, String dzh_mch) {
        this.dd_id = dd_id;
        this.yh_id = yh_id;
        this.chjshj = chjshj;
        this.jze = jze;
        this.shhr = shhr;
        this.jdh = jdh;
        this.yjsdsj = yjsdsj;
        this.dzh_mch = dzh_mch;
    }

    public String getDd_id() {
        return dd_id;
    }

    public void setDd_id(String dd_id) {
        this.dd_id = dd_id;
    }

    public String getYh_id() {
        return yh_id;
    }

    public void setYh_id(String yh_id) {
        this.yh_id = yh_id;
    }

    public String getChjshj() {
        return chjshj;
    }

    public void setChjshj(String chjshj) {
        this.chjshj = chjshj;
    }

    public Float getJze() {
        return jze;
    }

    public void setJze(Float jze) {
        this.jze = jze;
    }

    public String getShhr() {
        return shhr;
    }

    public void setShhr(String shhr) {
        this.shhr = shhr;
    }

    public Integer getJdh() {
        return jdh;
    }

    public void setJdh(Integer jdh) {
        this.jdh = jdh;
    }

    public String getYjsdsj() {
        return yjsdsj;
    }

    public void setYjsdsj(String yjsdsj) {
        this.yjsdsj = yjsdsj;
    }

    public String getDzh_mch() {
        return dzh_mch;
    }

    public void setDzh_mch(String dzh_mch) {
        this.dzh_mch = dzh_mch;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dd_id='" + dd_id + '\'' +
                ", yh_id='" + yh_id + '\'' +
                ", chjshj='" + chjshj + '\'' +
                ", jze=" + jze +
                ", shhr='" + shhr + '\'' +
                ", jdh=" + jdh +
                ", yjsdsj='" + yjsdsj + '\'' +
                ", dzh_mch='" + dzh_mch + '\'' +
                '}';
    }
}
