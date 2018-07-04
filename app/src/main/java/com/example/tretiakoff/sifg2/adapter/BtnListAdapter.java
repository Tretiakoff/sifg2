package com.example.tretiakoff.sifg2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.api.model.Answer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 07/06/2018.
 */

public class BtnListAdapter extends RecyclerView.Adapter<BtnListAdapter.TopRatedViewHolder> {

    private ArrayList<Answer> mAnswers = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private OnTopRatedClickListener mOnTopRatedOnClickListener;

    public BtnListAdapter(OnTopRatedClickListener mOnTopRatedOnClickListener) {
        this.mOnTopRatedOnClickListener = mOnTopRatedOnClickListener;
    }

    public static class TopRatedViewHolder extends RecyclerView.ViewHolder {

        private Button btn;

        TopRatedViewHolder(View topRatedItemLayout) {
            super(topRatedItemLayout);
            btn = topRatedItemLayout.findViewById(R.id.answerBtn);
        }
    }

    @Override
    public TopRatedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.item_btn, parent, false);
        return new TopRatedViewHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(TopRatedViewHolder holder, final int position) {

        final Answer mAnswser = mAnswers.get(position);
        holder.btn.setText(mAnswser.getText());

//        holder.topRatedContainer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mOnTopRatedOnClickListener.onTopRatedClick(mAnswser);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mAnswers.size();
    }

    public void setTopRatedList(ArrayList<Answer> answerList) {

        mAnswers = answerList;
    }

    public interface OnTopRatedClickListener{
        void onTopRatedClick(Answer animal);
    }
}
