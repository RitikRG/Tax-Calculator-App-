package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calcBtn;
    private TextView display;
    private EditText userIncome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcBtn = findViewById(R.id.calcBtn);
        display= findViewById(R.id.display);
        userIncome = findViewById(R.id.userIncome);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String incomeSrc = userIncome.getText().toString();
                long income = Integer.parseInt(incomeSrc);
                display.setText("Total Tax: ₹"+ calcTax(income));
            }
        });
    }
    private static double calcTax(long income) {
        if (income<250000){
            return 0.00;
        } else if (income<500000) {
            return ((income-250000)*0.05);
        } else if (income<750000) {
            return 12500+(income-500000)*0.1;
        } else if (income<1000000){
            return 37500+(income-750000)*0.15;
        } else if (income<1250000) {
            return 75000+(income-1000000)*0.2;
        } else if (income<1500000) {
            return 125000+(income-1250000)*0.25;
        }else {
            return 187500+(income-1500000)*0.3;
        }
    }
}