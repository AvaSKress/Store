package com.example.avaschembrikress_prog3210_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerInformation extends AppCompatActivity {
    private Button btnComplete;
    TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_information);
        btnComplete = findViewById(R.id.btnComplete);
        errorText = findViewById(R.id.textErrors);
        loadData();
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOrder();
            }
        });
    }

    private void loadData() {
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
        //getting info about chosen products
        String chosen_product = myPref.getString("chosen_product", "");
        TextView chosen_product_field;
        chosen_product_field = findViewById(R.id.selectedProduct);
        chosen_product_field.setText("You chose " + chosen_product);

        //getting info about the payment type
        String chosen_payment = myPref.getString("paymentType", "Cash");
        TextView textView_payment_type = findViewById(R.id.paymentType);
        Toast.makeText(this, "You chose: " + chosen_payment, Toast.LENGTH_SHORT).show();

        //cash payment options
        if (chosen_payment.equals("Cash")) {
            textView_payment_type.setText("You paying with cash");
            EditText card_number = (EditText) findViewById(R.id.cardNumber);
            card_number.setVisibility(View.INVISIBLE);
            EditText exp_date_field = (EditText) findViewById(R.id.txtExpDate);
            exp_date_field.setVisibility(View.INVISIBLE);
            TextView exp_date_label = (TextView) findViewById(R.id.lblExpDate);
            exp_date_label.setVisibility(View.INVISIBLE);
            EditText cvv_field = (EditText) findViewById(R.id.txtCvv);
            cvv_field.setVisibility(View.INVISIBLE);
            TextView cvv_label = (TextView) findViewById(R.id.lblCvv);
            cvv_label.setVisibility(View.INVISIBLE);
        } else if (chosen_payment.equals("Credit card")) {
            textView_payment_type.setText("You paying with credit card. Please, enter payment information");
        } else {
            textView_payment_type.setText("You paying with debit card. Please, enter payment information");
        }
    }

    public void confirmOrder() {
        // Initialize a flag to track if there are errors
        boolean error = false;

        // Initialize a StringBuilder to accumulate error messages
        StringBuilder errorMessage = new StringBuilder();

        // Validation for full name
        EditText full_name_Validate = findViewById(R.id.custName);
        String full_name = full_name_Validate.getText().toString().trim();
        if (full_name.isEmpty()) {
            errorMessage.append("No entered full name\n");
            error = true;
        } else {
            // Clear the error message for the "full_name" field if it's filled correctly
            errorMessage.append(" ");
            full_name_Validate.setError(null);
        }

        // Validation for favorite color
        EditText favourite_colour_Validate = findViewById(R.id.favColour);
        String favourite_colour = favourite_colour_Validate.getText().toString().trim();
        if (favourite_colour.isEmpty()) {
            errorMessage.append("No entered favorite color\n");
            error = true;
        } else {
            // Clear the error message for the "favorite_color" field if it's filled correctly
            errorMessage.append(" ");
            favourite_colour_Validate.setError(null);
        }

        // Validation for favorite number
        EditText favourite_number_Validate = findViewById(R.id.favNumber);
        String favourite_number = favourite_number_Validate.getText().toString().trim();
        if (favourite_number.isEmpty()) {
            errorMessage.append("No entered favorite number\n");
            error = true;
        } else {
            // Clear the error message for the "favorite_number" field if it's filled correctly
            errorMessage.append(" ");
            favourite_number_Validate.setError(null);
        }

        // Validation for favorite sport
        EditText favourite_sport_Validate = findViewById(R.id.favSport);
        String favourite_sport = favourite_sport_Validate.getText().toString().trim();
        if (favourite_sport.isEmpty()) {
            errorMessage.append("No entered favorite sport\n");
            error = true;
        } else {
            // Clear the error message for the "favorite_sport" field if it's filled correctly
            errorMessage.append(" ");
            favourite_sport_Validate.setError(null);
        }

        // Accessing payment choice to see if we need to validate banking card info
        SharedPreferences myPref = getSharedPreferences("info", MODE_PRIVATE);
        String chosen_payment = myPref.getString("chosen_payment", "Cash");
        if (!chosen_payment.equals("Cash")) {
            // Validation for credit/debit card number
            EditText card_number_Validate = findViewById(R.id.cardNumber);
            String card_number = card_number_Validate.getText().toString().trim();
            if (card_number.isEmpty()) {
                errorMessage.append("No entered card number\n");
                error = true;
            } else if (card_number.length() != 16) {
                errorMessage.append("Incorrect card number. Enter 16 digits\n");
                error = true;
            } else {
                // Clear the error message for the "card_number" field if it's filled correctly
                errorMessage.append(" ");
                card_number_Validate.setError(null);
            }

            // Validation for expiry date
            EditText exp_date_Validate = findViewById(R.id.txtExpDate);
            String exp_date_st = exp_date_Validate.getText().toString().trim();
            if (exp_date_st.length() != 4) {
                errorMessage.append("Incorrect expiry date\n");
                error = true;
            } else {
                // Clear the error message for the "expiry_date" field if it's filled correctly
                errorMessage.append(" ");
                exp_date_Validate.setError(null);
            }

            // Validation for CVV code
            EditText cvv_Validate = findViewById(R.id.txtCvv);
            String cvv = cvv_Validate.getText().toString().trim();
            if (cvv.length() != 3) {
                errorMessage.append("Incorrect CVV\n");
                error = true;
            } else {
                // Clear the error message for the "cvv" field if it's filled correctly
                errorMessage.append(" ");
                cvv_Validate.setError(null);
            }
        }

        // Display accumulated error messages in the errorText TextView
        errorText.setText(errorMessage.toString());

        // If there are no errors, clear the error message and proceed
        if (!error) {
            errorText.setText(" ");
            Toast.makeText(this, "Order successfully sent!", Toast.LENGTH_SHORT).show();
            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);
        }
    }
}