package com.mall.service.product;

public class Product1 {
    private String shp_id;          //品牌id+创
    private String shp_mch;         //商品名称
    private String flmch2;          //分类编号2
    private String ppmch;           //品牌名称
    private String chjshj;          //创建时间
    private String shp_msh;         //商品描述
    private Float shp_jg;           //商品价格
    private String shp_ys;          //颜色
    private Integer shp_kc;         //商品库存
    private String shp_zht;         //商品状态

    public Product1() {
    }

    public Product1(String shp_id, String shp_mch, String flmch2, String ppmch, String chjshj, String shp_msh, Float shp_jg, String shp_ys, Integer shp_kc, String shp_zht) {
        this.shp_id = shp_id;
        this.shp_mch = shp_mch;
        this.flmch2 = flmch2;
        this.ppmch = ppmch;
        this.chjshj = chjshj;
        this.shp_msh = shp_msh;
        this.shp_jg = shp_jg;
        this.shp_ys = shp_ys;
        this.shp_kc = shp_kc;
        this.shp_zht = shp_zht;
    }

    public String getShp_id() {
        return shp_id;
    }

    public void setShp_id(String shp_id) {
        this.shp_id = shp_id;
    }

    public String getShp_mch() {
        return shp_mch;
    }

    public void setShp_mch(String shp_mch) {
        this.shp_mch = shp_mch;
    }

    public String getFlmch2() {
        return flmch2;
    }

    public void setFlmch2(String flmch2) {
        this.flmch2 = flmch2;
    }

    public String getPpmch() {
        return ppmch;
    }

    public void setPpmch(String ppmch) {
        this.ppmch = ppmch;
    }

    public String getChjshj() {
        return chjshj;
    }

    public void setChjshj(String chjshj) {
        this.chjshj = chjshj;
    }

    public String getShp_msh() {
        return shp_msh;
    }

    public void setShp_msh(String shp_msh) {
        this.shp_msh = shp_msh;
    }

    public Float getShp_jg() {
        return shp_jg;
    }

    public void setShp_jg(Float shp_jg) {
        this.shp_jg = shp_jg;
    }

    public String getShp_ys() {
        return shp_ys;
    }

    public void setShp_ys(String shp_ys) {
        this.shp_ys = shp_ys;
    }

    public Integer getShp_kc() {
        return shp_kc;
    }

    public void setShp_kc(Integer shp_kc) {
        this.shp_kc = shp_kc;
    }

    public String getShp_zht() {
        return shp_zht;
    }

    public void setShp_zht(String shp_zht) {
        this.shp_zht = shp_zht;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "shp_id='" + shp_id + '\'' +
                ", shp_mch='" + shp_mch + '\'' +
                ", flmch2='" + flmch2 + '\'' +
                ", ppmch='" + ppmch + '\'' +
                ", chjshj='" + chjshj + '\'' +
                ", shp_msh='" + shp_msh + '\'' +
                ", shp_jg=" + shp_jg +
                ", shp_ys='" + shp_ys + '\'' +
                ", shp_kc=" + shp_kc +
                ", shp_zht='" + shp_zht + '\'' +
                '}';
    }
}
