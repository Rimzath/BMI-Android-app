package com.example.bmi_android_app;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView resultTextView, categoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTextView = findViewById(R.id.textViewResult);
        categoryTextView = findViewById(R.id.textViewCategory);

        float bmi = getIntent().getFloatExtra("bmi", 0);
        displayBMI(bmi);
    }

    private void displayBMI(float bmi) {
        String bmiText = String.format("Your BMI: %.2f", bmi);
        resultTextView.setText(bmiText);

        String category;
        int color;

        if (bmi < 16) {
            category = "Severe Thinness";
            color = Color.RED;
        } else if (bmi < 17) {
            category = "Moderate Thinness";
            color = Color.MAGENTA;
        } else if (bmi < 18.5) {
            category = "Mild Thinness";
            color = Color.YELLOW;
        } else if (bmi < 25) {
            category = "Normal";
            color = Color.GREEN;
        } else if (bmi < 30) {
            category = "Overweight";
            color = Color.YELLOW;
        } else if (bmi < 35) {
            category = "Obese Class I";
            color = Color.MAGENTA;
        } else if (bmi < 40) {
            category = "Obese Class II";
            color = Color.RED;
        } else {
            category = "Obese Class III";
            color = Color.RED;
        }

        categoryTextView.setText(category);
        categoryTextView.setTextColor(color);
    }
}
