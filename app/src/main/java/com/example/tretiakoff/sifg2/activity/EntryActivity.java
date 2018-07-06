package com.example.tretiakoff.sifg2.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;

public class EntryActivity extends AppCompatActivity {

    Button pathologyActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);


//        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.LEFT | Gravity.CENTER_VERTICAL);
//        View customNav = LayoutInflater.from(this).inflate(R.layout.action_bar, null); // layout which contains your button.
//        bar.setCustomView(customNav, lp);
//        bar.setDisplayHomeAsUpEnabled(true);


//        ImageButton imageButton = (ImageButton) mCustomView
//                .findViewById(R.id.imageButton);
//        imageButton.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
//                        Toast.LENGTH_LONG).show();
//            }
//        });

//        getSupportActionBar().setCustomView(R.layout.action_bar);
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
