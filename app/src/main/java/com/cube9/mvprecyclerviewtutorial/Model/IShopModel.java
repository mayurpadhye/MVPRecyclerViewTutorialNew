package com.cube9.mvprecyclerviewtutorial.Model;

import java.util.List;

public interface IShopModel {

    interface onFinishedListener
    {
        void onFinished(List<ShopList> shopLists);
        void onFailure(Throwable t);
    }

    void getShopList(onFinishedListener onFinishedListener);
}
