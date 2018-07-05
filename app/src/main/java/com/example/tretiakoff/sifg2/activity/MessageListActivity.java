package com.example.tretiakoff.sifg2.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.AnswerAdapter;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.api.client.Client;
import com.example.tretiakoff.sifg2.api.client.Sifg2;
import com.example.tretiakoff.sifg2.api.model.chat.Answer;
import com.example.tretiakoff.sifg2.api.model.chat.ChatResult;
import com.example.tretiakoff.sifg2.api.model.chat.Pathology;
import com.example.tretiakoff.sifg2.model.Message;

import java.util.ArrayList;

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
    private Integer nextId;
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
                    ChatResult result = response.body();
                    String question = result.getText();
                    Message firstMessage = new Message(getResources().getString(R.string.helloMsg), true);
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

                } else {
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

        if (answer.getText().equals(getResources().getString(R.string.personnalDoctor))) {
            Intent personnalDoctorIntent = new Intent(MessageListActivity.this, PersonnalDoctorActivity.class);
            startActivity(personnalDoctorIntent);

        }
       else if (answer.getText().equals(getResources().getString(R.string.otherDoctor))) {
            Intent doctorListIntent = new Intent(MessageListActivity.this, DoctorListActivity.class);
            Bundle b = new Bundle();
            b.putInt("pathologyId", answer.getPathology().getId());
            doctorListIntent.putExtras(b);
            startActivity(doctorListIntent);
            return;
        }
        else if (answer.getText().equals(getResources().getString(R.string.callEmergency))) {
            call();

        }
        sentMessage = answer.getText();
        Message sentMsg = new Message(sentMessage, false);
        messages.add(sentMsg);
        mMessageAdapter.notifyDataSetChanged();

        nextId = answer.getNext_question_id();

        if (answer.getEmergency()) {
            //REMOVE BTN show urgences num + button call
            answers.clear();
            Message receivedMessage = new Message(getResources().getString(R.string.emergencyMsg), true);
            messages.add(receivedMessage);
            mMessageAdapter.notifyDataSetChanged();
            mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());
            Answer callEmergency = new Answer(0, getResources().getString(R.string.callEmergency), false, 0, null );
            answers.add(callEmergency);
            answerAdapter.notifyDataSetChanged();
            return;
        }
        if (nextId == null) {
            //NEXT QUESTION : do you want to add some precision
            //NON -> Remove Btn
            //OUI -> REMOVE BTN + SHOW KEYBOARD TO ADD A COMMENT
            //CALLBACK when send pressed : your comment will be seen by a specialist
            Pathology pathology = answer.getPathology();
            Message receivedMessage = new Message(pathology.getLabel(), true);
            messages.add(receivedMessage);
            Message pathologyAfyer = new Message(getResources().getString(R.string.pathologyAfterMsg), true);
            Message contactDoctorMsg = new Message(getResources().getString(R.string.contactDoctorMsg), true);
            messages.add(pathologyAfyer);
            messages.add(contactDoctorMsg);
            mMessageAdapter.notifyDataSetChanged();
            mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());
            Answer personnalDoctor = new Answer(0, getResources().getString(R.string.personnalDoctor), false, 0, answer.getPathology());
            Answer otherDoctor = new Answer(0, getResources().getString(R.string.otherDoctor), false, 0, answer.getPathology() );
            answers.clear();
            answers.add(personnalDoctor);
            answers.add(otherDoctor);
            answerAdapter.notifyDataSetChanged();
            return;
        }
        retrofit2.Call call = service.getQuestions(nextId);
        call.enqueue(new Callback<ChatResult>() {
            @Override
            public void onResponse(Call<ChatResult> call, Response<ChatResult> response) {
                if (response.code() == 200) {
                    ChatResult result = response.body();

                    String question = result.getText();
                    if (!question.equals("")) {
                        Message receivedMessage = new Message(question, true);
                        messages.add(receivedMessage);
                        mMessageAdapter.notifyDataSetChanged();
                        mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());
                    }

                    answers = result.getAnswers();

                    if (answers.size() > 0) {
                        answerAdapter.setTopRatedList(answers);
                        answerAdapter.notifyDataSetChanged();
                        mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());
                    }

                    answerAdapter.setTopRatedList(answers);
                    answerAdapter.notifyDataSetChanged();
                    mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());

                } else {
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

    private void call() {
        if (ActivityCompat.checkSelfPermission(MessageListActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            try {
                String phone = "112";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            } catch (Exception e) {
                Log.d("EXCEPTION", e.getMessage());
            }

        } else {
            Log.d("ERROR", "CALLLING");
        }
    }

}

