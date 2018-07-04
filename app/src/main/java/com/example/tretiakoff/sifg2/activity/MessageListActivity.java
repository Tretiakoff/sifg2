package com.example.tretiakoff.sifg2.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.AnswerAdapter;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.api.client.Client;
import com.example.tretiakoff.sifg2.api.client.Sifg2;
import com.example.tretiakoff.sifg2.api.model.Answer;
import com.example.tretiakoff.sifg2.api.model.ChatResult;
import com.example.tretiakoff.sifg2.model.Message;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageListActivity  extends AppCompatActivity implements AnswerAdapter.OnBtnClickListener {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private RecyclerView mBtnRecycler;
    private AnswerAdapter answerAdapter;
    private TextView message;
    private Button sendMsgBtn;
    private TextView textInput;
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<Answer> answers = new ArrayList<>();
    private Boolean firstAnswer;
    private Sifg2 service = Client.getClient();
    private String sentMessage;
    private int nextQuestionId;
    Message receivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        sendMsgBtn = findViewById(R.id.button_chatbox_send);
        textInput = findViewById(R.id.edittext_chatbox);

        mMessageRecycler = findViewById(R.id.message_list_view);
        mMessageAdapter = new MessageListAdapter(MessageListActivity.this, messages);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(MessageListActivity.this));

        mMessageRecycler.setAdapter(mMessageAdapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MessageListActivity.this, LinearLayoutManager.HORIZONTAL, false);

        mBtnRecycler = findViewById(R.id.btn_list_view);

        answerAdapter = new AnswerAdapter(MessageListActivity.this);

        mBtnRecycler.setLayoutManager(layoutManager);
        mBtnRecycler.setAdapter(answerAdapter);

        retrofit2.Call call = service.getFirstQuestion();
        call.enqueue(new Callback<ChatResult>() {
            @Override
            public void onResponse(Call<ChatResult> call, Response<ChatResult> response) {
                if (response.code() == 200) {
                    Log.d("ERROR", "error");
                    ChatResult result = response.body();
                    String question = result.getText();
                    Message firstMessage = new Message("Bonjour, je vais vous aider à pré-identifier votre problème, cela facilitera le travail du médecin lors de votre consultation", true);
                    messages.add(firstMessage);
                    mMessageAdapter.notifyDataSetChanged();
                    receivedMessage = new Message(question, true);
                    if (!receivedMessage.equals("")) {
                        messages.add(receivedMessage);
                        mMessageAdapter.notifyDataSetChanged();
                    }

                    answers = result.getAnswers();

                    answerAdapter.setTopRatedList(answers);
                    answerAdapter.notifyDataSetChanged();

//                    nextQuestionId = answer.getNext_question_id();

                } else {
                    Log.d("ERROR", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });


        answerAdapter.setTopRatedList(answers);
        answerAdapter.notifyDataSetChanged();

    }
    @Override
    public void onBtnClick(Answer answer) {
        sentMessage = answer.getText();
        nextQuestionId = answer.getNext_question_id();

        Message receivedMessage = new Message(sentMessage, true);
        messages.add(receivedMessage);
        mMessageAdapter.notifyDataSetChanged();


        retrofit2.Call call = service.getQuestions(nextQuestionId);
        call.enqueue(new Callback<ChatResult>() {
            @Override
            public void onResponse(Call<ChatResult> call, Response<ChatResult> response) {
                if (response.code() == 200) {
                    ChatResult result = response.body();
                    String question = result.getText();
                    Message receivedMessage = new Message(question, true);
                    messages.add(receivedMessage);
                    mMessageAdapter.notifyDataSetChanged();

                    answers = result.getAnswers();

                    if (answers.size() > 0) {
                        answerAdapter.setTopRatedList(answers);
                        answerAdapter.notifyDataSetChanged();
                    }

                    answerAdapter.setTopRatedList(answers);
                    answerAdapter.notifyDataSetChanged();

                } else {
                    Log.d("ERROR", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });


    }
}

