package com.example.tretiakoff.sifg2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;

public class DoctorActivity extends AppCompatActivity {

    private TextView name;
    private TextView speciality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        name = findViewById(R.id.doctor_name_single);
        speciality = findViewById(R.id.doctor_speciality_single);

        Bundle b = getIntent().getExtras();

        String firstName = b.getString("firstName");
        String lastName = b.getString("lastName");
        String mSpeciality = b.getString("speciality");

        String finalName = firstName +
                " " +
                lastName;

        name.setText(finalName);
        speciality.setText(mSpeciality);
    }
}
