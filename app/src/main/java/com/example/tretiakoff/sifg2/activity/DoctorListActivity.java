package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.AnswerAdapter;
import com.example.tretiakoff.sifg2.adapter.DoctorListAdapter;
import com.example.tretiakoff.sifg2.adapter.MessageListAdapter;
import com.example.tretiakoff.sifg2.api.client.Client;
import com.example.tretiakoff.sifg2.api.client.Sifg2;
import com.example.tretiakoff.sifg2.api.model.chat.ChatResult;
import com.example.tretiakoff.sifg2.api.model.doctor.Doctor;
import com.example.tretiakoff.sifg2.api.model.doctor.DoctorResult;
import com.example.tretiakoff.sifg2.model.Message;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListActivity extends AppCompatActivity implements DoctorListAdapter.OnBtnClickListener{

    private int pathologyId;
    private Sifg2 service = Client.getClient();
    private JSONObject paramObject;
    private RecyclerView mDoctorRecyclerView;
    private DoctorListAdapter doctorAdapter;
    private ArrayList<Doctor> doctors;
    private TextView noDoctorMsg;
    private ImageButton messageBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(DoctorListActivity.this);

        mDoctorRecyclerView = findViewById(R.id.doctor_list_view);

        doctorAdapter = new DoctorListAdapter(DoctorListActivity.this);

        messageBack = findViewById(R.id.action_bar_back_message);

        messageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", "CLICK");
                Intent messageIntent = new Intent(DoctorListActivity.this, MessageListActivity.class);
                startActivity(messageIntent);
            }
        });

        mDoctorRecyclerView.setLayoutManager(layoutManager);
        mDoctorRecyclerView.setAdapter(doctorAdapter);

        Bundle b = getIntent().getExtras();

        pathologyId = b.getInt("pathologyId");

        Map<String, Object> jsonParams = new ArrayMap<>();

        jsonParams.put("latitude", 48.851846);
        jsonParams.put("longitude", 2.4205839999999625);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());
        retrofit2.Call call = service.getDoctors(pathologyId, body);
        call.enqueue(new Callback<DoctorResult>() {
            @Override
            public void onResponse(Call<DoctorResult> call, Response<DoctorResult> response) {
                if (response.code() == 204) {
                Intent notFoundIntent = new Intent(DoctorListActivity.this, NotFoundActivity.class);
                startActivity(notFoundIntent);
                }
               else if (response.code() == 200) {
                    Log.d("RESPONSE", "OK");
                    DoctorResult result = response.body();
                    if (result != null) {
                        doctors = result.getSpecialized_doctors();
                        doctorAdapter.setTopRatedList(doctors);
                        doctorAdapter.notifyDataSetChanged();
                    }

                } else {
                    Log.e("RESPONSE", "NOT DEUX CENT");
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

    @Override
    public void onBtnClick(Doctor doctor) {
        Intent doctorActivity = new Intent(DoctorListActivity.this, DoctorActivity.class);
        Bundle b = new Bundle();
        b.putString("firstName", doctor.getFirstname());
        b.putString("lastName", doctor.getLastname());
        b.putString("speciality", doctor.getSpecialty().getLabel());
        doctorActivity.putExtras(b);
        startActivity(doctorActivity);
    }
}
