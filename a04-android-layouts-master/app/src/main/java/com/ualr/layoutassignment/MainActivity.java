package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MaterialButton
            discount,
            calculate;
    CheckBox
            checkbox1,
            checkbox2,
            checkbox3,
            checkbox4;
    TextView
            totalCost;
    TextInputEditText
            cost;

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        discount = findViewById(R.id.discountButton);
        calculate = findViewById(R.id.calculateTotalButton);
        checkbox1 = findViewById(R.id.product1Box);
        checkbox2 = findViewById(R.id.product2Box);
        checkbox3 = findViewById(R.id.product3Box);
        checkbox4 = findViewById(R.id.product4Box);
        totalCost = findViewById(R.id.totalDollarAmountText);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    protected void calculateTotal(){
        double totalText = 0;
        String x;

        if(checkbox1.isChecked()){
            this.cost = findViewById(R.id.textBoxText1);
            x = cost.getText().toString();
            if(!x.matches("")) {
                totalText += Double.parseDouble(x);
            }

        }
        if(checkbox2.isChecked()){
            this.cost = findViewById(R.id.textBoxText2);
            x = cost.getText().toString();
            if(!x.matches("")) {
                totalText += Double.parseDouble(x);
            }
        }
        if(checkbox3.isChecked()){
            this.cost = findViewById(R.id.textBoxText3);
            x = cost.getText().toString();
            if(!x.matches("")) {
                totalText += Double.parseDouble(x);
            }
        }
        if(checkbox4.isChecked()){
            this.cost = findViewById(R.id.textBoxText4);
            x = cost.getText().toString();
            if(!x.matches("")) {
                totalText += Double.parseDouble(x);
            }
        }
        if(discount.isChecked()){
            totalText *= .75;
        }
        String s = String.format("%.2f", totalText);
        totalCost.setText(s);
    }
}