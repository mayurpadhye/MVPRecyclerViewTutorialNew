package com.cube9.mvprecyclerviewtutorial.View;

import com.cube9.mvprecyclerviewtutorial.Model.ShopList;

import java.util.List;

public interface IMainView {
    public void showPregressBar();
    public void hidePregressBar();
    public void setDataToRecyclerView(List<ShopList> lists);
    public void onResponseFailure(Throwable t);
}
