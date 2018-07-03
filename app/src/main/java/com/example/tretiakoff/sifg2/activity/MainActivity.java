package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tretiakoff.sifg2.R;

public class MainActivity extends AppCompatActivity {

    private Button chatViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatViewBtn = findViewById(R.id.chatBtn);

        chatViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatActivityIntent = new Intent(MainActivity.this, MessageListActivity.class);
                startActivity(chatActivityIntent);
            }
        });
    }
}
