package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cart_Adapter extends RecyclerView.Adapter<cart_Adapter.MyViewHolder> {

    Context gcontext;
    List<cart_model_or_pojo> psppp;

    public cart_Adapter( List<cart_model_or_pojo> psppp,Context gcontext) {
        this.gcontext = gcontext;
        this.psppp = psppp;
    }

    @NonNull
    @Override
    public cart_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(gcontext).inflate(R.layout.custom_cart_product,parent,false);
        return new cart_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cart_Adapter.MyViewHolder holder, int position) {
        holder.product_name.setText(psppp.get(position).getOrder_naame());
        holder.product_info.setText(psppp.get(position).getOrder_inffo());
        holder.product_price.setText(psppp.get(position).getOrder_prrice());
        holder.product_image.setImageResource(psppp.get(position).getOrder_image());
    }

    @Override
    public int getItemCount() {
        return psppp.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        TextView product_name,product_info,product_price;
        Button place_order;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            product_image = itemView.findViewById(R.id.imageView488);
            product_name  = itemView.findViewById(R.id.textView388);
            product_info  = itemView.findViewById(R.id.textView588);
            product_price = itemView.findViewById(R.id.textView688);
            place_order   = itemView.findViewById(R.id.button424);
        }
    }
}
