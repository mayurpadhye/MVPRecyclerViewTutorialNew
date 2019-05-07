package com.cube9.mvprecyclerviewtutorial.Presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cube9.mvprecyclerviewtutorial.Model.ShopList;
import com.cube9.mvprecyclerviewtutorial.R;
import com.cube9.mvprecyclerviewtutorial.network.WebServiceURLs;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ShopSaleAdapter extends RecyclerView.Adapter<ShopSaleAdapter.MyViewHolder> {
    List<ShopList> allProductPojoList;

    Context mctx;


    public ShopSaleAdapter(List<ShopList> allProductPojoList, Context mctx) {
        this.allProductPojoList = allProductPojoList;
        this.mctx = mctx;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_shop_list, parent, false);
       // itemView.getLayoutParams().width = (int) (getScreenWidth() / 1.5);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ShopList items = allProductPojoList.get(position);

        holder.tv_fragment.animate().alpha(0f).setDuration(2000);
        holder.tv_fragment.animate().alpha(1f).setDuration(2000);
        holder.tv_fragment.bringToFront();
        holder.tv_product_name.setText(items.getShop_name());




        Picasso.with(mctx).load(WebServiceURLs.SHOP_IMAGE + items.getShop_image()).into(holder.iv_product_image1);
        Picasso.with(mctx).load(WebServiceURLs.SHOP_IMAGE + items.getShop_image()).into(holder.iv_product_image2);
       // Glide.with(mctx).load("http://4.bp.blogspot.com/-zlCqi4iWQb8/Tk_iLyLnoVI/AAAAAAAAED4/egErzO8ARQ0/s1600/s%25C3%25BCti+4548.jpg").into(holder.iv_product_image1);
     //   Glide.with(mctx).setDefaultRequestOptions(requestOptions).load(WebServiceURLs.SHOP_IMAGE + items.getImage2()).into(holder.iv_product_image2);

        holder.tv_desc.setText(items.getShop_dec());



    }

    @Override
    public int getItemCount() {
        return allProductPojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_product_image2, iv_product_image1;
        ImageView iv_like;
        TextView tv_desc, tv_price_range, tv_product_name, tv_discount, tv_fragment;


        CardView cv_shop_main;


        public MyViewHolder(View view) {
            super(view);
            tv_fragment = view.findViewById(R.id.tv_premium);
            iv_product_image2 = (ImageView) view.findViewById(R.id.iv_product_image2);
            iv_product_image1 = (ImageView) view.findViewById(R.id.iv_product_image1);
            iv_like = (ImageView) view.findViewById(R.id.iv_like);
            tv_desc = (TextView) view.findViewById(R.id.tv_desc);
            tv_discount = (TextView) view.findViewById(R.id.tv_discount);
            tv_price_range = (TextView) view.findViewById(R.id.tv_price_range);
            tv_product_name = (TextView) view.findViewById(R.id.tv_product_name);


            //   shimmer.start(shimmer_premium);
        }
    }


}
