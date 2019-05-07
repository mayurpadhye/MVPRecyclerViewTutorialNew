package com.cube9.mvprecyclerviewtutorial.Presenter;

import com.cube9.mvprecyclerviewtutorial.Model.IShopModel;
import com.cube9.mvprecyclerviewtutorial.Model.ShopList;
import com.cube9.mvprecyclerviewtutorial.View.IMainView;

import java.util.List;

public class ShopPresenterImpl implements IShopPresenter,IShopModel.onFinishedListener {
    IMainView mainView;
    IShopModel iShopModel;

    public ShopPresenterImpl(IMainView mainView, IShopModel iShopModel) {
        this.mainView = mainView;
        this.iShopModel = iShopModel;
    }

    @Override
    public void onDestroy() {
mainView=null;
    }

    @Override
    public void requestDataFromServer() {
iShopModel.getShopList(this);
    }

    @Override
    public void onFinished(List<ShopList> shopLists) {
if (mainView!=null)
{
    mainView.setDataToRecyclerView(shopLists);
    mainView.hidePregressBar();
}
    }

    @Override
    public void onFailure(Throwable t) {
if (mainView!=null)
{
    mainView.onResponseFailure(t);
    mainView.hidePregressBar();
}
    }
}
