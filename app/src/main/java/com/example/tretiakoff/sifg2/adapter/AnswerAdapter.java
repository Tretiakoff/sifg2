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

import java.util.ArrayList;

/**
 * Created by tretiakoff on 07/06/2018.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private ArrayList<Answer> mAnswerList = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private OnBtnClickListener mOnBtnClickListener;

    public AnswerAdapter(OnBtnClickListener mOnBtnClickListener) {
        this.mOnBtnClickListener = mOnBtnClickListener;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.item_btn, parent, false);
        return new AnswerViewHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, final int position) {

        final Answer mAnswer = mAnswerList.get(position);
        holder.cover.setText(mAnswer.getText());


        holder.btnContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnBtnClickListener.onBtnClick(mAnswer);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAnswerList.size();
    }

    public void setTopRatedList(ArrayList<Answer> answerList) {

        mAnswerList = answerList;
    }

    public interface OnBtnClickListener {
        void onBtnClick(Answer answer);
    }

    public static class AnswerViewHolder extends RecyclerView.ViewHolder {

        private TextView cover;
        RelativeLayout btnContainer;

        AnswerViewHolder(View btnViewItemLayout) {
            super(btnViewItemLayout);
            btnContainer = (RelativeLayout) btnViewItemLayout;
            cover = btnViewItemLayout.findViewById(R.id.answerBtn);
        }
    }
}
