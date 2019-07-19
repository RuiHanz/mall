package com.mall.service.product;

public class ProductImages {
    private String tu_Id;          //图片id
    private String tu_mch;         //图片名称
    private String zy;             //图片作用
    private String shp_id;         //商品id
    private String url;            //图片地址

    public ProductImages() {
        super();
    }

    public ProductImages(String tu_Id, String tu_mch, String zy, String shp_id, String url) {
        this.tu_Id = tu_Id;
        this.tu_mch = tu_mch;
        this.zy = zy;
        this.shp_id = shp_id;
        this.url = url;
    }

    public String getTu_Id() {
        return tu_Id;
    }

    public void setTu_Id(String tu_Id) {
        this.tu_Id = tu_Id;
    }

    public String getTu_mch() {
        return tu_mch;
    }

    public void setTu_mch(String tu_mch) {
        this.tu_mch = tu_mch;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getShp_id() {
        return shp_id;
    }

    public void setShp_id(String shp_id) {
        this.shp_id = shp_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProductImages{" +
                "tu_Id='" + tu_Id + '\'' +
                ", tu_mch='" + tu_mch + '\'' +
                ", zy='" + zy + '\'' +
                ", shp_id='" + shp_id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
