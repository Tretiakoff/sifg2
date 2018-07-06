package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tretiakoff.sifg2.R;

public class NotFoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_found);
    }

    @Override
    public void onBackPressed() {
        Intent entryIntent = new Intent(NotFoundActivity.this, MessageListActivity.class);
        startActivity(entryIntent);
        super.onBackPressed();
    }
}
