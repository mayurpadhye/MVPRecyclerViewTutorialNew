package com.cube9.mvprecyclerviewtutorial.Model;

import android.util.Log;

import com.cube9.mvprecyclerviewtutorial.network.RestInterface;
import com.cube9.mvprecyclerviewtutorial.network.RetrofitClient;
import com.cube9.mvprecyclerviewtutorial.network.WebServiceURLs;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ShopList implements IShopModel {

    String shop_id, shop_name, shop_image, shop_dec;
List<ShopList> shopLists=new ArrayList<>();
    public ShopList() {

    }

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

    @Override
    public void getShopList(final onFinishedListener onFinishedListener) {

        RetrofitClient retrofitClient = new RetrofitClient();
        RestInterface service = retrofitClient.getAPIClient(WebServiceURLs.DOMAIN_NAME);
        service.getAllShopAndSale(new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                //this method call if webservice success
                try {

                    JSONObject jsonObject = new JSONObject(jsonElement.toString());
                    String status = jsonObject.getString("status");

                    if (status.equals("1")) {
                        JSONArray data = null;

                        data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject j1 = data.getJSONObject(i);
                            String id = j1.getString("id");
                            String name = j1.getString("name");
                            String user_id = j1.getString("user_id");
                            String preference_id = j1.getString("preference_id");
                            String address_line1 = j1.getString("address_line1");
                            String address_line2 = j1.getString("address_line2");
                            String city = j1.getString("city");
                            String state = j1.getString("state");
                            String country = j1.getString("country");
                            String pincode = j1.getString("pincode");
                            String lat = j1.getString("lat");
                            String lon = j1.getString("lon");
                            String low_price = j1.getString("low_price");
                            String high_price = j1.getString("high_price");
                            String min_discount = j1.getString("min_discount");
                            String max_discount = j1.getString("max_discount");
                            String start_date = j1.getString("start_date");
                            String end_date = j1.getString("end_date");
                            String phone = j1.getString("phone");
                            String hash_tags = j1.getString("hash_tags");
                            String description = j1.getString("description");
                            String web_url = j1.getString("web_url");
                            String image2="";
                            String image1="";
                            if(j1.has("image1")) {

                                image1 = j1.getString("image1");
                            }
                            if(j1.has("image2"))
                            {
                                image2 = j1.getString("image2");
                            }

                            String image = "";

                            shopLists.add(new ShopList(id,shop_name,image1,shop_dec));

                        }


                    }

                    onFinishedListener.onFinished(shopLists);

                } catch (JSONException | NullPointerException e) {

                    e.printStackTrace();
                    Log.i("fdfdfdfdfdf", "" + e.getMessage());

                }
            }

            @Override
            public void failure(RetrofitError error) {

                onFinishedListener.onFailure(error);
                Log.i("fdfdfdfdfdf", "" + error.getMessage());

            }
        });
    }
}
