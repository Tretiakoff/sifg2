package com.example.tretiakoff.sifg2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText;
    String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText = findViewById(R.id.welcomeText);
        //welcomeText.setText("Hello Gaoussou");

        welcomeText.postDelayed(new Runnable() {
            public void run() {
                welcomeText.setText(getResources().getString(R.string.test_string));
                //welcomeText.setText("Hello Gaoussou.");
            }
        }, 5000);
    }
}
