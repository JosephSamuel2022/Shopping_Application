package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class home_product_Adapter extends RecyclerView.Adapter<home_product_Adapter.ViewHolder> {

    ArrayList<home_product_model_or_pojo> itemlist123;
    Context mcontext;

    public home_product_Adapter(ArrayList<home_product_model_or_pojo> itemlist, Context mcontext) {
        this.itemlist123 = itemlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public home_product_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_hom_product_show,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull home_product_Adapter.ViewHolder holder, int position) {

        home_product_model_or_pojo pss =itemlist123.get(position);

        holder.name.setText(pss.name);
        holder.namdd.setText(pss.named);
        holder.pricc.setText(pss.pric);
        holder.img.setImageResource(pss.getImage());
        holder.btn.setOnClickListener(v -> {
            Toast.makeText(mcontext, "Adding to Cart", Toast.LENGTH_SHORT).show();
            Toast.makeText(mcontext, "Item Added to the Cart", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return itemlist123.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,namdd,pricc;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                img = itemView.findViewById(R.id.dress);
                name = itemView.findViewById(R.id.textView3);
                namdd = itemView.findViewById(R.id.textView5);
                pricc = itemView.findViewById(R.id.textView6);
                btn = itemView.findViewById(R.id.button3);
        }
    }
}
