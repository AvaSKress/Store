package com.example.avaschembrikress_prog3210_lab02_ex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class Furniture extends AppCompatActivity {

    //declaring views
    private CheckBox cbF1, cbF2;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

        //setting references
        cbF1 = findViewById(R.id.cbFurniture1);
        cbF2 = findViewById(R.id.cbFurniture2);
        btnCheckout = findViewById(R.id.checkout_button);

        //OnClickListener for addToView method
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToView();
            }
        });
    }
    //method to add item to checkout
    public void addToView(){
        SharedPreferences myPreference = getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = myPreference.edit();

        //checking and saving info from checkboxes
        boolean f1Checked = cbF1.isChecked();
        boolean f2Checked = cbF2.isChecked();
        prefEditor.putBoolean("f1Checked",f1Checked);
        prefEditor.putBoolean("f2Checked",f2Checked);
        prefEditor.commit();
        Intent checkoutIntent = new Intent(getApplicationContext(), Checkout.class);
        startActivity(checkoutIntent);
    }
    //creating option menu to select product
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    //sending user to product pages
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appliances_item:
                Intent apartment = new Intent(this, Appliance.class);
                startActivity(apartment);
                break;
            case R.id.tvs_item:
                Intent tv = new Intent(this, Tv.class);
                startActivity(tv);
                break;
            case R.id.computers_item:
                Intent computer = new Intent(this, Computers.class);
                startActivity(computer);
                break;
            case R.id.furniture_item:
                Intent furniture = new Intent(this, Furniture.class);
                startActivity(furniture);
                break;
            case R.id.autoaccessories_item:
                Intent auto = new Intent(this, AutoAccessories.class);
                startActivity(auto);
                break;
        }
        return true;
    }
}