package com.cube9.mvprecyclerviewtutorial.Model;

public class ShopList  {

    String shop_id,shop_name,shop_image,shop_dec;


    public ShopList(String shop_id, String shop_name, String shop_image, String shop_dec) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_image = shop_image;
        this.shop_dec = shop_dec;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_image() {
        return shop_image;
    }

    public void setShop_image(String shop_image) {
        this.shop_image = shop_image;
    }

    public String getShop_dec() {
        return shop_dec;
    }

    public void setShop_dec(String shop_dec) {
        this.shop_dec = shop_dec;
    }
}
