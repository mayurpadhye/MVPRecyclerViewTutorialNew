package com.cube9.mvprecyclerviewtutorial.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cube9.mvprecyclerviewtutorial.Model.ShopList;
import com.cube9.mvprecyclerviewtutorial.Presenter.IShopPresenter;
import com.cube9.mvprecyclerviewtutorial.Presenter.ShopPresenterImpl;
import com.cube9.mvprecyclerviewtutorial.Presenter.ShopSaleAdapter;
import com.cube9.mvprecyclerviewtutorial.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {
ProgressBar p_bar;
RecyclerView rv_main;
IShopPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main=findViewById(R.id.rv_main);
        p_bar=findViewById(R.id.p_bar);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rv_main.setLayoutManager(verticalLayoutManager);
        presenter=new ShopPresenterImpl(this,new ShopList());
        presenter.requestDataFromServer();
    }


    @Override
    public void showPregressBar() {

    }

    @Override
    public void hidePregressBar() {

    }

    @Override
    public void setDataToRecyclerView(List<ShopList> lists) {

        ShopSaleAdapter adapter=new ShopSaleAdapter(lists,MainActivity.this);
        rv_main.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }


}
