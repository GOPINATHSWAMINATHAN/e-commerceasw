package com.aswaqqnet.it.aswaqqapp;

import android.graphics.Bitmap;
import android.widget.Toast;

/**
 * Created by IT on 10/2/2017.
 */

public class HomePojo {

    public Bitmap image;
    public int discount;
    public String product_name;
    public String old_price;
    public String new_price;

    public HomePojo(Bitmap image, int discount, String product_name, String old_price, String new_price) {
        this.image = image;
        this.discount = discount;
        this.product_name = product_name;
        this.old_price = old_price;
        this.new_price = new_price;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getDiscount() {
        return discount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getOld_price() {
        return old_price;
    }

    public String getNew_price() {
        return new_price;
    }
}
