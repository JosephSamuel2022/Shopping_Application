package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmenthomeBinding;
import com.example.myapplication.home_product_Adapter;
import com.example.myapplication.home_product_model_or_pojo;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<home_product_model_or_pojo> itemlist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmenthome, container, false);
        recyclerView = view.findViewById(R.id.recycle123);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter( new home_product_Adapter(initdata(),getActivity()));
        return view;
    }

    private ArrayList<home_product_model_or_pojo> initdata() {
        itemlist = new ArrayList<>();
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop100png, "LEVI,s", "White woman t-shirt", "Rs.1050"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.cello005, "CELLO", "Water Bottles - 4", "Rs.1750"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop300png, "VIVO", "VIVO NEX", "Rs.10500"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop400png, "APPLE", "IPHONE X", "Rs.85000"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop500png, "SAMSUNG", "SAMSUNG GALAXY NOTE 7", "Rs.1550"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop600png, "SONY", "SONY EXPERIA E-3", "Rs.18000"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.books0009, "BOOK", "MY FIRST LIBRARY", "Rs.105"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop700png, "BOOK", "FAIRY TALES", "Rs.305"));
        itemlist.add(new home_product_model_or_pojo(R.drawable.shop800png, "BOOK", "THE BROKEN GOD", "Rs.1050"));

        return itemlist;
    }


}