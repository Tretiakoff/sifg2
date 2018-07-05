package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tretiakoff.sifg2.R;

public class EntryActivity extends AppCompatActivity {

    Button pathologyActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        pathologyActivityBtn = findViewById(R.id.problem_Btn);
        pathologyActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pathoIntent = new Intent(EntryActivity.this, PathologyActivity.class);
                startActivity(pathoIntent);

            }
        });
    }
}
