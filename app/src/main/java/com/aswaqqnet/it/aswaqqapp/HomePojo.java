package com.aswaqqnet.it.aswaqqapp;

import android.graphics.Bitmap;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by IT on 10/2/2017.
 */

public class HomePojo {

    public ArrayList image;
    public int discount;
    public ArrayList<String> product_name;
    public ArrayList<String> old_price;
    public ArrayList<String> new_price;
public HomePojo()
{

}
    public HomePojo(ArrayList image, int discount, ArrayList<String> product_name, ArrayList<String> old_price, ArrayList<String> new_price) {
        this.image = image;
        this.discount = discount;
        this.product_name = product_name;
        this.old_price = old_price;
        this.new_price = new_price;
    }

    public ArrayList getImage() {
        return image;
    }

    public int getDiscount() {
        return discount;
    }

    public ArrayList<String> getProduct_name() {
        return product_name;
    }

    public ArrayList<String> getOld_price() {
        return old_price;
    }

    public ArrayList<String> getNew_price() {
        return new_price;
    }
}
