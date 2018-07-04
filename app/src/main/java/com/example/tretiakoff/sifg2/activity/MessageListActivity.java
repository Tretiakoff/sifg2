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

        Answer answer = new Answer(1, "OUI", 3, false);
        Answer answer1 = new Answer(2, "FUU", 2, false);
        Answer answer2 = new Answer(23, "FOUOU", 2, false);

        answers.add(answer);
        answers.add(answer1);
        answers.add(answer2);

        answerAdapter.setTopRatedList(answers);
        answerAdapter.notifyDataSetChanged();

        retrofit2.Call call = service.getFirstQuestion();
        Log.d("CALLL", "BEGAN");
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
                    messages.add(receivedMessage);
                    mMessageAdapter.notifyDataSetChanged();

                    Button myButton = new Button(MessageListActivity.this);
                    myButton.setText("Push Me");




                    ArrayList<Answer> answers = result.getAnswers();

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


//        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sentMessage = textInput.getText().toString();
//                Message sentMsg = new Message(sentMessage, false);
//                messages.add(sentMsg);
//                mMessageAdapter.notifyDataSetChanged();
//
//                if (firstAnswer == true) {
//                    Log.d("FIRST", "TRUE");
//                    String bodyZone = textInput.getText().toString().toLowerCase().trim();
//                    if (!bodyZone.equals("ventre")) {
//                        receivedMessage = new Message("Désolé, je ne traite pas encore les pathologies liées à cette zone du corps.", true);
//                        messages.add(receivedMessage);
//                        mMessageAdapter.notifyDataSetChanged();
//                        return;
//                    }
//                }
//
//                retrofit2.Call call = service.getQuestions(nextQuestionId);
//                call.enqueue(new Callback<ChatResult>() {
//                    @Override
//                    public void onResponse(Call<ChatResult> call, Response<ChatResult> response) {
//                        if (response.code() == 200) {
//                            ChatResult result = response.body();
//                            Log.d("RESP", "290000");
//                            String question = result.getText();
//                            Log.d("RESP",question);
//                            Message receivedMessage = new Message(question, true);
//                            messages.add(receivedMessage);
//                            mMessageAdapter.notifyDataSetChanged();
//                            firstAnswer = false;
//
//                        } else {
//                            Log.d("ERROR", "error");
//                            return;
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call call, Throwable t) {
//                        Log.d("ERROR", t.getMessage());
//                        return;
//                    }
//                });
//
//
//            }
//        });

//        message = findViewById(R.id.text_message_body);
//        message.setText("COUCOU");


    }
    @Override
    public void onBtnClick(Answer answer) {
        Log.e("FUCCCCCCK", "FUCK");
    }
}
