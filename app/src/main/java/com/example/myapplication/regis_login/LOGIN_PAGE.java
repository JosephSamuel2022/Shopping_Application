package com.example.myapplication.regis_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.database_helper.DataBase_Helper;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LOGIN_PAGE extends AppCompatActivity {

    TextInputLayout textInputLayout1,textInputLayout2;
    TextInputEditText email,password;

    Button btn;
    TextView txt;

    DataBase_Helper dataBase_helper;
    INPUT_VALIDATION input_validation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Objects.requireNonNull(getSupportActionBar()).hide();


        textInputLayout1 = findViewById(R.id.lay1);
        textInputLayout2 = findViewById(R.id.lay_2);


        email = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);

        btn = findViewById(R.id.button2);
        txt = findViewById(R.id.textView4);



        dataBase_helper = new DataBase_Helper(this);
        input_validation = new INPUT_VALIDATION(this);


        btn.setOnClickListener(v -> {

            String gmail = Objects.requireNonNull(email.getText()).toString().trim();
            String pass = Objects.requireNonNull(password.getText()).toString().trim();

            if (gmail.equals("") || pass.equals("")) {
                Toast.makeText(LOGIN_PAGE.this, "PLEASE ENTER ALL THE FIELDS", Toast.LENGTH_SHORT).show();
            }
            else {
                boolean check_user_gmail_pass = dataBase_helper.check_gmail_password(gmail, pass);
                if (check_user_gmail_pass) {
                    Toast.makeText(LOGIN_PAGE.this, "SIGN IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(LOGIN_PAGE.this, MainActivity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(LOGIN_PAGE.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }


            SharedPreferences shadow = getSharedPreferences("demo01",MODE_PRIVATE);
            SharedPreferences.Editor editor = shadow.edit();

            editor.putString("str001",gmail);
            editor.apply();


        });



        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LOGIN_PAGE.this, REGISTRATION_PAGE.class);
                startActivity(intent);
            }
        });
    }
}