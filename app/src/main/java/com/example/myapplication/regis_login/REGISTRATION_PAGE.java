package com.example.myapplication.regis_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.database_helper.DataBase_Helper;
import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class REGISTRATION_PAGE extends AppCompatActivity {


    TextInputLayout name_layout1,email_layout2,pass_layout3,confirm_pass_layout4;
    EditText name1,email2,pass3,confirm_pass4;

    Button register;
    TextView txt;

    INPUT_VALIDATION input_validation;
    DataBase_Helper dataBase_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        Objects.requireNonNull(getSupportActionBar()).hide();

//      ALL LAYOUTS
        name_layout1 = findViewById(R.id.lay_name);
        email_layout2 = findViewById(R.id.lay_email);
        pass_layout3 = findViewById(R.id.lay_pass);
        confirm_pass_layout4 = findViewById(R.id.lay_com_pass);

//      ALL EDIT TEXTS
        name1 = findViewById(R.id.tname);
        email2 = findViewById(R.id.temail);
        pass3 = findViewById(R.id.tpassword);
        confirm_pass4 = findViewById(R.id.t_confirm_password);

//        ALL BUTTONS
        register = findViewById(R.id.button1034);
        txt = findViewById(R.id.already);

        input_validation = new INPUT_VALIDATION(this);
        dataBase_helper  = new DataBase_Helper(this);


        register.setOnClickListener(v -> {
            String user_NAME = name1.getText().toString();
            String user_GMAIL = email2.getText().toString();
            String user_paswword = pass3.getText().toString();
            String user_confirm  = confirm_pass4.getText().toString();

            if (user_NAME.equals("")|| user_paswword.equals("") || user_confirm.equals("")){
                Toast.makeText(REGISTRATION_PAGE.this, "PLEASE ENTER THE ALL THE FIELDS ", Toast.LENGTH_SHORT).show();
                if (!input_validation.input_fill(name1, name_layout1, "Enter the name")){
                return;
            }
                input_validation.email_pattern_check(email2, email_layout2, "Enter valid Email");


            }
            else{
                if (user_paswword.equals(user_confirm)) {
                    boolean checkuser = dataBase_helper.check_gmail(user_GMAIL);

                    if (!checkuser) {
                        if (!input_validation.email_pattern_check(email2,email_layout2,"Enter valid Email")){
                            return;
                        }
                        boolean check_username = dataBase_helper.check_user_name(user_NAME);
                        if (!check_username) {
                            boolean insert = dataBase_helper.insertData(user_NAME, user_paswword, user_GMAIL);
                            if (insert) {
                                Toast.makeText(REGISTRATION_PAGE.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(REGISTRATION_PAGE.this, LOGIN_PAGE.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(REGISTRATION_PAGE.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(REGISTRATION_PAGE.this, "user already exists\nPlease sign in", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else {
                        Toast.makeText(REGISTRATION_PAGE.this, "G-mail already exists", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    input_validation.password_check(pass3, confirm_pass4, confirm_pass_layout4, "Password is not matching");

                    Toast.makeText(REGISTRATION_PAGE.this, "Password not matching", Toast.LENGTH_SHORT).show();
                }
            }



            SharedPreferences shd = getSharedPreferences("demo",MODE_PRIVATE);
            SharedPreferences.Editor editor = shd.edit();

            editor.putString("str",user_NAME);
            editor.putString("str1",user_GMAIL);
            editor.apply();

        });



        txt.setOnClickListener(v -> {
            Intent intent1 = new Intent(REGISTRATION_PAGE.this,LOGIN_PAGE.class);
            startActivity(intent1);
        });
    }
}