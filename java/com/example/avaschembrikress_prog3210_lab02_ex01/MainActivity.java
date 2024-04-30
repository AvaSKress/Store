package com.example.avaschembrikress_prog3210_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnter = findViewById(R.id.buttonEnter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productTypes = new Intent(getApplicationContext(), ProductType.class);
                startActivity(productTypes);
            }
        });
    }
}