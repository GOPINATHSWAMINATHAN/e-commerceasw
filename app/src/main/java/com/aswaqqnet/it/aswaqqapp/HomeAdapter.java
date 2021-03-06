package com.aswaqqnet.it.aswaqqapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<HomePojo> homeLists = new ArrayList();
    Context context;
    ArrayList image;
    int discount;
    ArrayList<String> product_name;
    ArrayList<String> old_price;
    ArrayList<String> new_price;

    public HomeAdapter(Context context, ArrayList image,
            int discount,
            ArrayList<String> product_name,
            ArrayList<String> old_price,
            ArrayList<String> new_price) {
        this.context = context;
        this.image=image;
        this.discount=discount;
        this.product_name=product_name;
        this.old_price=old_price;
        this.new_price=new_price;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        itemView.setOnClickListener(HomeFragment.myOnClickListener);
        MyViewHolder vHolder = new MyViewHolder(itemView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomePojo hp = homeLists.get(position);
        //holder.productImage.setImageBitmap((Bitmap) hp.getImage().get(position));
        //holder.discount.setText(hp.getDiscount());
        Picasso.with(context).load(String.valueOf(image.get(position))).resize(120, 60).into((Target) image);
        holder.oldPrice.setText(old_price.get(position));
        holder.discount.setText(discount);
        holder.newPrice.setText(new_price.get(position));
        holder.productName.setText(product_name.get(position));
        Log.e("ADAPTER DATA ARE ", "" + hp.getNew_price() + "" + hp.getOld_price() + "" + hp.getNew_price());
    }

    @Override
    public int getItemCount() {
        return homeLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Context context = itemView.getContext();

        public ImageView productImage;
        TextView discount, oldPrice, newPrice, productName;
        CardView productCard;
        Button viewProduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.imgview);
            discount = itemView.findViewById(R.id.discount_price);
            oldPrice = itemView.findViewById(R.id.old_price);
            newPrice = itemView.findViewById(R.id.new_price);
            productName = itemView.findViewById(R.id.product_name);
            productCard = itemView.findViewById(R.id.first_card);
            viewProduct = itemView.findViewById(R.id.fazalur);
            RelativeLayout check_progress = (RelativeLayout) itemView.findViewById(R.layout.progress_bar);

            viewProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent check1 = new Intent(context, ProductDisplay.class);
                    check1.putExtra("pos", getAdapterPosition());
                    context.startActivity(check1);
                }
            });

            productCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //     Toast.makeText(context,getAdapterPosition(),Toast.LENGTH_LONG).show();
                    Intent check = new Intent(context, ProductDisplay.class);
                    check.putExtra("pos", getAdapterPosition());
                    context.startActivity(check);
                }
            });
        }
    }
}



