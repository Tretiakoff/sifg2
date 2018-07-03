package com.example.tretiakoff.sifg2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.model.Message;
import com.example.tretiakoff.sifg2.model.User;

import java.util.ArrayList;
import java.util.Calendar;

public class MessageListActivity  extends AppCompatActivity implements MessageListAdapter.OnTopRatedClickListener {

    private MessageListAdapter mMessageAdapter;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("STATUS", "NAISSANCE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        RecyclerView mRecyclerView = findViewById(R.id.reyclerview_message_list);
        message = findViewById(R.id.text_message_body);
        message.setText("COUCOU");


        mMessageAdapter = new MessageListAdapter(MessageListActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));
        mRecyclerView.setAdapter(mMessageAdapter);

        User me = new User("andré", "google.com");

        Message message1= new Message("salut", me, 1234_5678_9012_3456L);
        Message message2= new Message("coucou", me, 1234_5678_9012_3456L);
        Message message3= new Message("encore????", me, 1234_5678_9012_3456L);
        Message message4= new Message("tais toi", me, 1234_5678_9012_3456L);

        ArrayList<Message> results = new ArrayList<>();

        results.add(message1);
        results.add(message2);
        results.add(message3);
        results.add(message4);

        mRecyclerView.setAdapter(mMessageAdapter);
        mMessageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTopRatedClick(Message animal) {
        Log.d("HELLO", "oui");
    }
}
