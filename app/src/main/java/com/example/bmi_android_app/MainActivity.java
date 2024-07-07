package com.example.bmi_android_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi_android_app.R;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText, heightEditText, weightEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageEditText = findViewById(R.id.text1);
        heightEditText = findViewById(R.id.text2);
        weightEditText = findViewById(R.id.text3);
        calculateButton = findViewById(R.id.button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageStr = ageEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr)) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else {
            int age = Integer.parseInt(ageStr);
            if (age < 18) {
                Toast.makeText(this, "The app is for adults 18 years or older", Toast.LENGTH_SHORT).show();
                return;
            }
            float height = Float.parseFloat(heightStr)/100 ;
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);

            Intent intent = new Intent(MainActivity.this, com.example.bmi_android_app.SecondActivity.class);
            intent.putExtra("bmi", bmi);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setMessage("Do you want to exit from these App?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
