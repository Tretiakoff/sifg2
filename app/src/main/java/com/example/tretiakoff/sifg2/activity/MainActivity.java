package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tretiakoff.sifg2.R;

public class MainActivity extends AppCompatActivity {

    private Button menuViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuViewBtn = findViewById(R.id.nextPage);

        menuViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatActivityIntent = new Intent(MainActivity.this, EntryActivity.class);
                startActivity(chatActivityIntent);
            }
        });
    }
}