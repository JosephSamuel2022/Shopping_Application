package com.example.myapplication;

public class cart_model_or_pojo {


    public cart_model_or_pojo() {
    }

    int order_image;
    String order_naame,order_inffo,order_prrice;

    public cart_model_or_pojo(int order_image, String order_naame, String order_inffo, String order_prrice) {
        this.order_image = order_image;
        this.order_naame = order_naame;
        this.order_inffo = order_inffo;
        this.order_prrice = order_prrice;
    }

    public int getOrder_image() {
        return order_image;
    }

    public void setOrder_image(int order_image) {
        this.order_image = order_image;
    }

    public String getOrder_naame() {
        return order_naame;
    }

    public void setOrder_naame(String order_naame) {
        this.order_naame = order_naame;
    }

    public String getOrder_inffo() {
        return order_inffo;
    }

    public void setOrder_inffo(String order_inffo) {
        this.order_inffo = order_inffo;
    }

    public String getOrder_prrice() {
        return order_prrice;
    }

    public void setOrder_prrice(String order_prrice) {
        this.order_prrice = order_prrice;
    }
}
