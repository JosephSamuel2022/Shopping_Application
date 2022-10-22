package com.example.myapplication.regis_login;

import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class INPUT_VALIDATION {

    Context context;

    public INPUT_VALIDATION(Context context) {
        this.context = context;
    }

    // now check if edit text is empty then show the error massage means name,gmail,password
// for that we will use boolean

    public boolean input_fill(EditText editText, TextInputLayout textInputLayout, String massage) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputLayout.setError(massage);
            if (textInputLayout.getChildCount() == 1){
                textInputLayout.getChildAt(1).setVisibility(View.GONE);
            }
            return true;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return false;
    }

// now check if in email section email pattern is correct or not
    // for that we also use boolean

    public boolean email_pattern_check(EditText editText,TextInputLayout textInputLayout,String massage) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(massage);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    // now check if entered password and confirm password are same or not
    // for that we also use boolean

    public boolean password_check(EditText editText, EditText editText1, TextInputLayout textInputLayout, String massage){
        String value  = editText.getText().toString().trim();
        String value1 = editText1.getText().toString().trim();
        if (!value.contentEquals(value1)){
            textInputLayout.setError(massage);
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    }








