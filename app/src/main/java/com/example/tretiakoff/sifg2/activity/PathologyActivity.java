package com.example.tretiakoff.sifg2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.adapter.DoctorListAdapter;
import com.example.tretiakoff.sifg2.adapter.PathologyAdapter;
import com.example.tretiakoff.sifg2.api.client.Client;
import com.example.tretiakoff.sifg2.api.client.Sifg2;
import com.example.tretiakoff.sifg2.api.model.PathologyResult;
import com.example.tretiakoff.sifg2.api.model.chat.Pathology;
import com.example.tretiakoff.sifg2.api.model.doctor.Doctor;
import com.example.tretiakoff.sifg2.api.model.doctor.DoctorResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PathologyActivity extends AppCompatActivity implements PathologyAdapter.OnBtnClickListener {

    private Button chatViewBtn;
    private RecyclerView mPathologyRecycler;
    private PathologyAdapter pathologyAdapter;
    private ArrayList<Pathology> pathologies;
    private Sifg2 service = Client.getClient();
    private ImageButton headerBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathology);

        mPathologyRecycler = findViewById(R.id.pathology_list_view);

        pathologyAdapter = new PathologyAdapter(PathologyActivity.this);

        mPathologyRecycler.setLayoutManager(new LinearLayoutManager(PathologyActivity.this));
        mPathologyRecycler.setAdapter(pathologyAdapter);

        chatViewBtn = findViewById(R.id.chatBtn);
        headerBack = findViewById(R.id.action_bar_back);

        headerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entryIntent = new Intent(PathologyActivity.this, EntryActivity.class);
                startActivity(entryIntent);
            }
        });

        chatViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatActivityIntent = new Intent(PathologyActivity.this, MessageListActivity.class);
                startActivity(chatActivityIntent);
            }
        });


        retrofit2.Call call = service.getPathologies();
        call.enqueue(new Callback<PathologyResult>() {
            @Override
            public void onResponse(Call<PathologyResult> call, Response<PathologyResult> response) {
                if (response.code() == 200) {
                    Log.d("HITHERE", "HIII");
                    PathologyResult result = response.body();
                    if (result != null) {
                        pathologies = result.getPathologies();
                        pathologyAdapter.setTopRatedList(pathologies);
                        pathologyAdapter.notifyDataSetChanged();
                        Log.d("COUNT", pathologies.toString());
                    }

                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                return;
            }
        });
    }
    @Override
    public void onBtnClick(Pathology pathology) {
        Intent doctorListIntent = new Intent(PathologyActivity.this, DoctorListActivity.class);
        Bundle b = new Bundle();
        b.putInt("pathologyId",pathology.getId());
        doctorListIntent.putExtras(b);
        startActivity(doctorListIntent);
        return;

    }
}
