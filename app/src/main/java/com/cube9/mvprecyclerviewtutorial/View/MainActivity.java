package com.cube9.mvprecyclerviewtutorial.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.cube9.mvprecyclerviewtutorial.R;

public class MainActivity extends AppCompatActivity implements IMainView {
ProgressBar p_bar;
RecyclerView rv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main=findViewById(R.id.rv_main);
        p_bar=findViewById(R.id.p_bar);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rv_main.setLayoutManager(verticalLayoutManager);

    }


    @Override
    public void showPregressBar() {

    }

    @Override
    public void hidePregressBar() {

    }

    @Override
    public void setDataToRecyclerView() {

    }

    @Override
    public void onResponseFailure() {

    }
}
