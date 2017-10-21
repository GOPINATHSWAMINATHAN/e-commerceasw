package com.aswaqqnet.it.aswaqqapp;

import java.util.ArrayList;

/**
 * Created by IT on 10/21/2017.
 */

public class WomenPojo {
    ArrayList product_code=new ArrayList();
    ArrayList product_image=new ArrayList();
    ArrayList product_name=new ArrayList();
    ArrayList price=new ArrayList();
public WomenPojo()
{

}
    public WomenPojo(ArrayList product_code, ArrayList product_image, ArrayList product_name, ArrayList price) {
        this.product_code = product_code;
        this.product_image = product_image;
        this.product_name = product_name;
        this.price = price;
    }

    public ArrayList getProduct_code() {
        return product_code;
    }

    public void setProduct_code(ArrayList product_code) {
        this.product_code = product_code;
    }

    public ArrayList getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ArrayList product_image) {
        this.product_image = product_image;
    }

    public ArrayList getProduct_name() {
        return product_name;
    }

    public void setProduct_name(ArrayList product_name) {
        this.product_name = product_name;
    }

    public ArrayList getPrice() {
        return price;
    }

    public void setPrice(ArrayList price) {
        this.price = price;
    }
}
