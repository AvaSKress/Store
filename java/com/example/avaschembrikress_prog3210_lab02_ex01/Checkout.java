package com.example.avaschembrikress_prog3210_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    //declaring views
    boolean a1Checked, a2Checked, tv1Checked, tv2Checked, com1Checked, com2Checked, f1Checked, f2Checked, aut1Checked, aut2Checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        getSavedDetails();
        getVisitedProduct();

        //button to go to payment page
        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the PaymentOptionsActivity
                Intent intent = new Intent(Checkout.this, PaymentType.class);
                startActivity(intent);
            }
        });
    }

    //saving checkboxes to false
    private void getSavedDetails() {
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
        a1Checked = myPref.getBoolean("a1Checked", false);
        a2Checked = myPref.getBoolean("a2Checked", false);
        tv1Checked = myPref.getBoolean("tv1Checked", false);
        tv2Checked = myPref.getBoolean("tv2Checked", false);
        com1Checked = myPref.getBoolean("c1Checked", false);
        com2Checked = myPref.getBoolean("c2Checked", false);
        f1Checked = myPref.getBoolean("f1Checked", false);
        f2Checked = myPref.getBoolean("f2Checked", false);
        aut1Checked = myPref.getBoolean("aut1Checked", false);
        aut2Checked = myPref.getBoolean("aut2Checked", false);
    }

    @SuppressLint("ResourceType")
    private void getVisitedProduct() {
        boolean options_exist = false; // to check for selected options
        RadioGroup rg = (RadioGroup) findViewById(R.id.rbVistedProduct);

        //checking every checkbox and adding radio button if it's checked
        if (a1Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.fridge);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.appliance1));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (a2Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.stove);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.appliance2));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (tv1Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.tv1);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.tv1));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (tv2Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.tv2);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.tv2));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if(com1Checked){
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.computer1);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.computer1));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if(com2Checked){
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.computer2);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.computer2));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (f1Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.couch);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.couch));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (f2Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.table);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.table));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (aut1Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.mats);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.mats));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        if (aut2Checked) {
            View radioButtonView = LayoutInflater.from(this).inflate(R.layout.product, null);
            // set image
            ImageView imageView = radioButtonView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.covers);
            // set text
            TextView textView = radioButtonView.findViewById(R.id.textView);
            textView.setText(getString(R.string.covers));
            //add radiobutton
            rg.addView(radioButtonView);
            options_exist = true;
        }
        //if no options dont make button visible
        if (!options_exist) {
            Button PayOpt_button = (Button) findViewById(R.id.btnNext);
            PayOpt_button.setVisibility(View.INVISIBLE);
        }
    }

}