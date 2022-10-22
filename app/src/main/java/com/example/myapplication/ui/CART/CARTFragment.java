package com.example.myapplication.ui.CART;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.sign_out.after_placer_order;
import com.example.myapplication.cart_Adapter;
import com.example.myapplication.cart_model_or_pojo;
import com.example.myapplication.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CARTFragment extends Fragment {

    FragmentCartBinding binding;
    RecyclerView recyclerView005;
    ConstraintLayout constraintLayout;
    Button btn;
    ArrayList<cart_model_or_pojo> itemlist008;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater, container, false);

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView005 = view.findViewById(R.id.recyclerView003);
        recyclerView005.setHasFixedSize(true);
        recyclerView005.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView005.setAdapter( new cart_Adapter(initdata05(),getActivity()));

        btn = view.findViewById(R.id.button424);
        constraintLayout = view.findViewById(R.id.sd123);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Your order has successfully placed", Toast.LENGTH_SHORT).show();
                Fragment fragment = new after_placer_order();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.sd123, fragment);
                constraintLayout.removeAllViews();
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private ArrayList<cart_model_or_pojo> initdata05() {
        itemlist008 = new ArrayList<>();
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop100png, "LEVI,s", "White woman t-shirt", "Rs.1050"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.cello005, "CELLO", "Water Bottles - 4", "Rs.1750"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop300png, "VIVO", "VIVO NEX", "Rs.10500"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop400png, "APPLE", "IPHONE X", "Rs.105000"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop500png, "SAMSUNG", "SAMSUNG GALAXY NOTE 7", "Rs.1550"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop600png, "SONY", "SONY EXPERIA E-3", "Rs.18000"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.books0009, "BOOK", "MY FIRST LIBRARY", "Rs.105"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop700png, "BOOK", "FAIRY TALES", "Rs.305"));
        itemlist008.add(new cart_model_or_pojo(R.drawable.shop800png, "BOOK", "THE BROKEN GOD", "Rs.1050"));

        return itemlist008;
    }

}