package com.aswaqqnet.it.aswaqqapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

private List<HomePojo> homeLists;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        itemView.setOnClickListener(HomeFragment.myOnClickListener);
        MyViewHolder  vHolder=new MyViewHolder(itemView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomePojo hp=homeLists.get(position);
        holder.productImage.setImageResource(hp.getImage());
//        holder.discount.setText(hp.getDiscount());
        holder.oldPrice.setText(hp.getOld_price());
        holder.newPrice.setText(hp.getNew_price());
        holder.productName.setText(hp.getProduct_name());
    }

    @Override
    public int getItemCount() {
        return homeLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
{
    Context context=itemView.getContext();

    public ImageView productImage;
    TextView discount,oldPrice,newPrice,productName;
    CardView productCard;
    Button viewProduct;
    public MyViewHolder(View itemView) {
        super(itemView);
        productImage=itemView.findViewById(R.id.imgview);
        discount=itemView.findViewById(R.id.discount_price);
        oldPrice=itemView.findViewById(R.id.old_price);
        newPrice=itemView.findViewById(R.id.new_price);
        productName=itemView.findViewById(R.id.product_name);
        productCard=itemView.findViewById(R.id.first_card);
        viewProduct=itemView.findViewById(R.id.fazalur);
        viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent check=new Intent(context,ProductDisplay.class);
                check.putExtra("pos",getAdapterPosition());
                context.startActivity(check);
            }
        });
        productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //     Toast.makeText(context,getAdapterPosition(),Toast.LENGTH_LONG).show();
                Intent check=new Intent(context,ProductDisplay.class);
                check.putExtra("pos",getAdapterPosition());
                context.startActivity(check);

            }
        });

    }

}
public HomeAdapter(List<HomePojo> homeLists)
{
    this.homeLists=homeLists;
}

}
