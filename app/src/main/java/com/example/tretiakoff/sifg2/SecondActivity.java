package com.example.tretiakoff.sifg2;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText;
    String myString;
    Button btn;
    ImageView img;
    ConstraintLayout myView;

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

        btn = findViewById(R.id.dodoButton);
        img = findViewById(R.id.dodoimageView);
        myView = findViewById(R.id.secondActivity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.dodo);
                myView.setBackgroundColor(getResources().getColor(R.color.colorRed));

            }
        });

        // set bg color
        myView.setBackgroundColor(getResources().getColor(R.color.colorBlue));
    }
}
