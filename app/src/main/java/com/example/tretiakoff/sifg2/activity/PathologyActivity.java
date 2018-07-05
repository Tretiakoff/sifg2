package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tretiakoff.sifg2.R;

public class PathologyActivity extends AppCompatActivity {

    private Button chatViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathology);

        chatViewBtn = findViewById(R.id.chatBtn);

        chatViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatActivityIntent = new Intent(PathologyActivity.this, MessageListActivity.class);
                startActivity(chatActivityIntent);
            }
        });
    }
}
