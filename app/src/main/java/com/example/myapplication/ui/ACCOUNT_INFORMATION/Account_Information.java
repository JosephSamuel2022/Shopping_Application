package com.example.myapplication.ui.ACCOUNT_INFORMATION;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myapplication.databinding.FragmentAccountInformationBinding;

public class Account_Information extends Fragment {

     FragmentAccountInformationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAccountInformationBinding.inflate(inflater, container, false);


        SharedPreferences getshared = requireActivity().getSharedPreferences("demo",MODE_PRIVATE);
        String value = getshared.getString("str","Hello");
        String value1 = getshared.getString("str1","GoodBYe");
        binding.textview.setText(value);
        binding.tix1.setText(value);
        binding.textview1.setText(value1);
        binding.tix2.setText(value1);


        SharedPreferences getshared01 = requireActivity().getSharedPreferences("demo01",MODE_PRIVATE);
        String value01 = getshared01.getString("str001","Null");
        binding.textview1.setText(value01);
        binding.tix2.setText(value01);


        return binding.getRoot();
    }


}