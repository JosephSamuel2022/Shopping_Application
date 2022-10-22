package com.example.myapplication;

public class home_product_model_or_pojo {
    int image;
    String name,named,pric;

    public home_product_model_or_pojo(int image, String name, String named, String pric) {
        this.image = image;
        this.name = name;
        this.named = named;
        this.pric = pric;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }
}
