package com.example.avaschembrikress_prog3210_lab02_ex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ProductType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);
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