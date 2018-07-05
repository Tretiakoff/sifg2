package com.example.tretiakoff.sifg2.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.api.model.chat.Answer;
import com.example.tretiakoff.sifg2.api.model.doctor.Doctor;
import com.example.tretiakoff.sifg2.api.model.doctor.DoctorResult;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 07/06/2018.
 */

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder> {

    private ArrayList<Doctor> mDoctorList = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private OnBtnClickListener mOnBtnClickListener;

    public DoctorListAdapter(OnBtnClickListener mOnBtnClickListener) {
        this.mOnBtnClickListener = mOnBtnClickListener;
    }

    @Override
    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(DoctorViewHolder holder, final int position) {

        final Doctor mDoctor = mDoctorList.get(position);

        String finalString = mDoctor.getFirstname() +
                " " +
                mDoctor.getLastname();

        holder.name.setText(finalString);
        holder.speciality.setText(mDoctor.getSpecialty().getLabel());


        holder.btnContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnBtnClickListener.onBtnClick(mDoctor);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDoctorList.size();
    }

    public void setTopRatedList(ArrayList<Doctor> doctorList) {

        mDoctorList = doctorList;
    }

    public interface OnBtnClickListener {
        void onBtnClick(Doctor doctor);
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView speciality;
        RelativeLayout btnContainer;

        DoctorViewHolder(View doctorViewItemLayout) {
            super(doctorViewItemLayout);
            btnContainer = (RelativeLayout) doctorViewItemLayout;
            name = doctorViewItemLayout.findViewById(R.id.doctor_name);
            speciality = doctorViewItemLayout.findViewById(R.id.doctor_speciality);
        }
    }
}
