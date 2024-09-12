package com.example.oterridiscountapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.oterridiscountapp.databinding.ActivityPinCodeBinding;

import java.util.List;

public class PinCodeActivity extends AppCompatActivity {
    ActivityPinCodeBinding binding;
    private static final int MAX_LENGTH = 4;

    List<View> btnNumPads;
    PreferenceManager preferenceManager;
    String codeString = "";

    String tokenStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pin_code);
        init();
    }

    public void init() {
        // Set up the clear button
        binding.btnClear.setOnClickListener(v -> {
            if (codeString.length() > 0) {
                // remove last character of code
                codeString = removeLastChar(codeString);
                // update dots layout
                setDotImagesState();
            }
        });

        // Set up the number buttons
        binding.btn0.setOnClickListener(this::onNumberClick);
        binding.btn1.setOnClickListener(this::onNumberClick);
        binding.btn2.setOnClickListener(this::onNumberClick);
        binding.btn3.setOnClickListener(this::onNumberClick);
        binding.btn4.setOnClickListener(this::onNumberClick);
        binding.btn5.setOnClickListener(this::onNumberClick);
        binding.btn6.setOnClickListener(this::onNumberClick);
        binding.btn7.setOnClickListener(this::onNumberClick);
        binding.btn8.setOnClickListener(this::onNumberClick);
        binding.btn9.setOnClickListener(this::onNumberClick);
    }

    private void onNumberClick(View v) {
        Button button = (Button) v;
        codeString += button.getTag().toString();
        if (codeString.length() == MAX_LENGTH) {
            CheckMPIN(codeString);
        } else if (codeString.length() > MAX_LENGTH) {
            // reset the input code
            codeString = "";
            codeString += button.getTag().toString();
        }
        setDotImagesState();
    }

    private void CheckMPIN(String Mpin) {
        String myPin="1234";
        if (myPin.equalsIgnoreCase(Mpin)){
            Intent i = new Intent(PinCodeActivity.this, VendorListActivity.class);
            startActivity(i);
            finish();
        }else {
            Toast.makeText(this, "incorrect pin", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDotImagesState() {
        List<ImageView> dots = List.of(binding.dot1, binding.dot2, binding.dot3, binding.dot4);
        for (int i = 0; i < codeString.length(); i++) {
            dots.get(i).setImageResource(R.drawable.ic_black_enable);
        }
        if (codeString.length() < 4) {
            for (int j = codeString.length(); j < 4; j++) {
                dots.get(j).setImageResource(R.drawable.ic_greay_dicable);
            }
        }
    }

    private String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length() - 1);
    }

    private void cleanAll() {
        if (codeString.length() > 0) {
            codeString = "";
            setDotImagesState();
        }
    }
}
