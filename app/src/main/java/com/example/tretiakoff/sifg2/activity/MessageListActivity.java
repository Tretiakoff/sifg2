package com.example.tretiakoff.sifg2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.model.Message;

import java.util.ArrayList;

public class MessageListActivity  extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private TextView message;
    private Button sendMsgBtn;
    private TextView textInput;

    private ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("STATUS", "NAISSANCE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        RecyclerView mRecyclerView = findViewById(R.id.message_list_view);
        sendMsgBtn = findViewById(R.id.button_chatbox_send);
        textInput = findViewById(R.id.edittext_chatbox);

        mMessageRecycler = findViewById(R.id.message_list_view);
        mMessageAdapter = new MessageListAdapter(MessageListActivity.this, messages);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));

        mMessageRecycler.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));
        mMessageRecycler.setAdapter(mMessageAdapter);

        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message(textInput.getText().toString(), false);
                Message receivedMsg = new Message(textInput.getText().toString(), true);
                messages.add(message);
                messages.add(receivedMsg);
                mMessageAdapter.notifyDataSetChanged();
                textInput.setText("");
            }
        });

//        message = findViewById(R.id.text_message_body);
//        message.setText("COUCOU");


    }

}
