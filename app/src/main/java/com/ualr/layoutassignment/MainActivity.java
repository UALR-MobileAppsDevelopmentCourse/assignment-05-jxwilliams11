package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    private ActivityMainBinding mBinding;

    MaterialButton discount;
    MaterialButton calculate;
    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox4;
    TextView totalCost;
    TextInputEditText cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        discount = findViewById(R.id.discountButton);
        calculate = findViewById(R.id.calculateTotalButton);
        checkbox1 = findViewById(R.id.product1Box);
        checkbox2 = findViewById(R.id.product2Box);
        checkbox3 = findViewById(R.id.product3Box);
        checkbox4 = findViewById(R.id.product4Box);
        totalCost = findViewById(R.id.totalDollarAmountText);

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){calculateTotal();}
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