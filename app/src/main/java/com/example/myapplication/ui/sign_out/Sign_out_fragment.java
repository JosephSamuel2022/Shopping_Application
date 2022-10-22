package com.example.myapplication.ui.sign_out;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.regis_login.LOGIN_PAGE;

public class Sign_out_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent intent = new Intent(getActivity(), LOGIN_PAGE.class);
        startActivity(intent);
        Toast.makeText(getActivity(), "Sign-out Success fully", Toast.LENGTH_SHORT).show();


        return inflater.inflate(R.layout.fragment_sign_out_fragment, container, false);
    }
}