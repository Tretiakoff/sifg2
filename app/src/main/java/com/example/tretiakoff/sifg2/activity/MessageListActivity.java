package com.example.tretiakoff.sifg2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.model.Message;
import com.example.tretiakoff.sifg2.model.User;

import java.util.ArrayList;
import java.util.Calendar;

public class MessageListActivity extends AppCompatActivity {

    private MessageListAdapter mMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

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

        Log.d("COUNT", results.toString());

        setContentView(R.layout.activity_message_list);
        RecyclerView mRecyclerView = findViewById(R.id.reyclerview_message_list);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMessageAdapter = new MessageListAdapter (MessageListActivity.this, results);
        mRecyclerView.setAdapter(mMessageAdapter);

//        mMessageAdapter = new MessageListAdapter(MessageListActivity.this, results);
//        mMessageAdapter
//
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));
//
//        mRecyclerView.setAdapter(mMessageAdapter);

//        mMessageAdapter = new MessageListAdapter(MessageListActivity.this, results);
//        RecyclerView mMessageRecycler = findViewById(R.id.reyclerview_message_list);
//
//        mMessageRecycler.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));
//        mMessageRecycler.setAdapter(mMessageAdapter);
//        mMessageAdapter.setMessageList(results);
//        mMessageAdapter.notifyDataSetChanged();

        Log.d("coucou", "uouaciciiciciciccici");
    }
}
